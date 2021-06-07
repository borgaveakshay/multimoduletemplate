package com.example.datastore.datastoreImpl

import com.example.datastore.dao.WeatherDao
import com.example.datastore.entities.WeatherEntity
import com.example.datastore.mappers.WeatherEntityMapper
import com.example.datastore.store.WeatherDataStore
import com.example.models.GetWeatherResponse
import com.example.models.utils.DateUtil
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*


class WeatherDataStoreImpl(
    private val weatherDao: WeatherDao,
    private val weatherEntityMapper: WeatherEntityMapper
) : WeatherDataStore {
    override fun addWeatherUpdate(
        city: String,
        response: GetWeatherResponse
    ): Observable<List<GetWeatherResponse>> {
        weatherDao.insert(
            WeatherEntity(
                cityName = city,
                temp = response.main.temp,
                date = DateUtil.getAbbreviatedFromDateTime(Calendar.getInstance().timeInMillis),
                country = response.sys.country
            )
        ).subscribeOn(
            Schedulers.io()
        ).subscribe()
        return getWeather(city)
    }

    override fun getWeather(city: String): Observable<List<GetWeatherResponse>> =
        weatherDao.getAllWeatherData().map { dbList ->
            val list = mutableListOf<GetWeatherResponse>()
            dbList.forEach {
                list.add(weatherEntityMapper.mapFrom(it))
            }
            list
        }

}