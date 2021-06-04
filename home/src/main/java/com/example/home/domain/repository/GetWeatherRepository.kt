package com.example.home.domain.repository

import com.example.home.data.models.GetWeatherRequest
import com.example.home.data.models.GetWeatherResponse
import io.reactivex.rxjava3.core.Observable

interface GetWeatherRepository {
    fun getWeather(weatherRequest: GetWeatherRequest): Observable<GetWeatherResponse>
}