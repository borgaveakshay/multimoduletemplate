package com.example.home.data.repositoriesimpl

import android.app.Application
import com.example.datastore.store.WeatherDataStore
import com.example.home.R
import com.example.home.data.api.WeatherAPI
import com.example.home.data.api.appId
import com.example.home.domain.repository.GetWeatherRepository
import com.example.models.GetWeatherResponse
import com.example.models.request.GetWeatherRequest
import com.example.models.response.Resource
import io.reactivex.rxjava3.core.Observable

class GetWeatherRepoImpl(
    private val api: WeatherAPI,
    private val dataStore: WeatherDataStore,
    private val context : Application
) : GetWeatherRepository {

    override fun getWeather(weatherRequest: GetWeatherRequest?): Observable<Resource<GetWeatherResponse>> {
        return weatherRequest?.let { request ->
            api.getWeather(request.city, appId).map { response ->
                dataStore.addWeatherUpdate(request.city, response)
                Resource.success(response)
            }.onErrorReturn { Resource.error(null, context.getString(R.string.network_data_unavailable)) }
        } ?: Observable.just<Resource<GetWeatherResponse>>(Resource.error(null, "empty"))
    }
}