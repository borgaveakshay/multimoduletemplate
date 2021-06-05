package com.example.datastore.datastoreImpl

import androidx.lifecycle.LiveData
import com.example.datastore.store.WeatherDataStore
import com.example.models.GetWeatherResponse

class WeatherDataStoreImpl: WeatherDataStore {
    override fun addWeatherUpdate(city: String, response: GetWeatherResponse) {
        TODO("Not yet implemented")
    }

    override fun getWeather(city: String): LiveData<GetWeatherResponse> {
        TODO("Not yet implemented")
    }
}