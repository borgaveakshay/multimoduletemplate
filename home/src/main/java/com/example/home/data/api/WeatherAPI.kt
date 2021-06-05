package com.example.home.data.api

import com.example.models.GetWeatherResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path

const val appId = "a2fb3445a09fbaf15553015915c0a80a"

interface WeatherAPI {


    @GET("api.openweathermap.org/data/2.5/weather?q={cityname}&appid={apikey}")
    fun getWeather(
        @Path("cityname") cityName: String,
        @Path("apikey") appId: String
    ): Observable<GetWeatherResponse>
}