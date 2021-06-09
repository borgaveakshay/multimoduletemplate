package com.example.home.domain.repository

import com.example.models.GetWeatherResponse
import com.example.models.request.GetWeatherRequest
import com.example.models.response.Resource
import io.reactivex.rxjava3.core.Observable

interface GetWeatherRepository {
    fun getWeather(weatherRequest: GetWeatherRequest?): Observable<Resource<GetWeatherResponse>>
}