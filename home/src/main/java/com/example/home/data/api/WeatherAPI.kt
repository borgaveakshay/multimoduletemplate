package com.example.home.data.api

import com.example.models.GetWeatherResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val appId = "a2fb3445a09fbaf15553015915c0a80a"

interface WeatherAPI {


    @GET("/data/2.5/weather?")
    fun getWeather(
        @Query("q") cityName: String,
        @Query("appid") appId: String
    ): Observable<GetWeatherResponse>
}