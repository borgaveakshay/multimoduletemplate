package com.example.datastore.datastoreImpl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.datastore.dao.WeatherDao
import com.example.datastore.entities.WeatherEntity
import com.example.datastore.store.WeatherDataStore
import com.example.models.GetWeatherResponse
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class WeatherDataStoreImpl @Inject constructor(private val weatherDao: WeatherDao) :
    WeatherDataStore {
    override fun addWeatherUpdate(city: String, response: GetWeatherResponse) {
        Schedulers.io().scheduleDirect {
            weatherDao.insert(WeatherEntity(cityName = city, temp = response.main.temp))
        }.dispose()
    }

    override fun getWeather(city: String): LiveData<WeatherEntity> {
        var result: LiveData<WeatherEntity> = MutableLiveData()
        Schedulers.io().scheduleDirect {
            result = weatherDao.getWeatherOfCity(city)
        }.dispose()

        return result
    }

}