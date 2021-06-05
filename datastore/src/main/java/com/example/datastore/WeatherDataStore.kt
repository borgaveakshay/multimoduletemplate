package com.example.datastore

import androidx.lifecycle.LiveData
import com.example.models.GetWeatherResponse

interface WeatherDataStore {

    fun addWeatherUpdate(city: String, response: GetWeatherResponse)

    fun getWeather(city: String): LiveData<GetWeatherResponse>
}