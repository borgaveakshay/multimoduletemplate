package com.example.datastore.store

import androidx.lifecycle.LiveData
import com.example.datastore.entities.WeatherEntity
import com.example.models.GetWeatherResponse
import io.reactivex.rxjava3.core.Observable

interface WeatherDataStore {

    fun addWeatherUpdate(city: String, response: GetWeatherResponse): Observable<List<GetWeatherResponse>>

    fun getWeather(city: String): Observable<List<GetWeatherResponse>>
}