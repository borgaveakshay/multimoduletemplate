package com.example.home.data.repositoriesimpl

import com.example.datastore.store.WeatherDataStore
import com.example.home.data.api.WeatherAPI
import com.example.home.data.api.appId
import com.example.home.domain.repository.GetWeatherRepository
import com.example.models.GetWeatherResponse
import com.example.models.request.GetWeatherRequest
import io.reactivex.rxjava3.core.Observable

class GetWeatherRepoImpl(
    private val api: WeatherAPI,
    private val dataStore: WeatherDataStore
) : GetWeatherRepository {

    override fun getWeather(weatherRequest: GetWeatherRequest?): Observable<GetWeatherResponse> {
        return weatherRequest?.let { request ->
            val result = api.getWeather(request.city, appId)
            // store data in database
            result.map { response ->
                dataStore.addWeatherUpdate(request.city, response)
            }
            result
        } ?: Observable.empty()
    }
}