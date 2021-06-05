package com.example.home.domain.repository

import com.example.models.GetWeatherResponse
import com.example.models.request.GetWeatherRequest
import io.reactivex.rxjava3.core.Observable

interface GetWeatherRepository {
    fun getWeather(weatherRequest: GetWeatherRequest?): Observable<GetWeatherResponse>
}