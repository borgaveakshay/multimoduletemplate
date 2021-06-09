package com.example.home.data.repositoriesimpl

import android.app.Application
import com.example.datastore.store.WeatherDataStore
import com.example.home.data.api.WeatherAPI
import com.example.home.testutils.TestUtils
import com.example.models.request.GetWeatherRequest
import io.reactivex.rxjava3.core.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class GetWeatherRepoImplTest {

    lateinit var repoImpl: GetWeatherRepoImpl
    lateinit var api: WeatherAPI
    lateinit var dataStore: WeatherDataStore
    lateinit var request: GetWeatherRequest
    lateinit var context: Application


    @Before
    fun before() {
        api = Mockito.mock(WeatherAPI::class.java)
        dataStore = Mockito.mock(WeatherDataStore::class.java)
        context = Mockito.mock(Application::class.java)
        request = GetWeatherRequest("Pune")
        repoImpl = GetWeatherRepoImpl(api, dataStore, context)
    }


    @Test
    fun when_api_response_is_successful() {
        // GIVEN
        givenSuccessfulResponse()
        // WHEN
        val result = repoImpl.getWeather(request).test()
        // THEN
        result.assertValue {
            it.data?.sys?.country === "IN"
            it.data?.main?.temp == 230.0
        }.assertComplete()
    }

    private fun givenSuccessfulResponse() {
        Mockito.`when`(api.getWeather(Mockito.anyString(), Mockito.anyString())).thenReturn(
            Observable.just(TestUtils.getWeatherData())
        )
    }

}