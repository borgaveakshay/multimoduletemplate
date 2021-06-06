package com.example.datastore.datastoreImpl

import com.example.datastore.dao.WeatherDao
import com.example.datastore.entities.WeatherEntity
import com.example.datastore.mappers.WeatherEntityMapper
import com.example.datastore.store.WeatherDataStore
import com.example.models.GetWeatherResponse
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

class WeatherDataStoreImpl @Inject constructor(
    private val weatherDao: WeatherDao,
    private val weatherEntityMapper: WeatherEntityMapper
) : WeatherDataStore {
    override fun addWeatherUpdate(city: String, response: GetWeatherResponse) {
        weatherDao.insert(
            WeatherEntity(
                cityName = city,
                temp = response.main.temp,
                date = Calendar.getInstance().timeInMillis
            )
        ).subscribeOn(
            Schedulers.io()
        )
    }

    override fun getWeather(city: String): Observable<GetWeatherResponse> =
        weatherDao.getWeatherOfCity(city).map {
            weatherEntityMapper.mapFrom(it)
        }

}