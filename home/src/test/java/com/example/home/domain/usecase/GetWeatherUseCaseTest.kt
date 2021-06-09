package com.example.home.domain.usecase

import com.example.base.transformers.TestTransformer
import com.example.home.domain.repository.GetWeatherRepository
import com.example.home.testutils.TestUtils
import com.example.models.request.GetWeatherRequest
import com.example.models.response.Resource
import io.reactivex.rxjava3.core.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class GetWeatherUseCaseTest  {

    lateinit var repository: GetWeatherRepository
    lateinit var useCase: GetWeatherUseCase
    lateinit var request: GetWeatherRequest

     @Before
     fun before() {
         repository = Mockito.mock(GetWeatherRepository::class.java)
         useCase = GetWeatherUseCase(TestTransformer(), repository)
         request = GetWeatherRequest("Pune")
     }

    @Test
    fun when_get_whether_response_is_success() {
        // GIVEN
        givenSuccessfulResponse()

        // WHEN
       val result = useCase(request).test()

        // THEN
        result.assertValue {
            it.data?.sys?.country === "IN"
            it.data?.main?.temp == 230.0
        }.assertComplete()
    }


    private fun givenSuccessfulResponse() {
        Mockito.`when`(repository.getWeather(request))
            .thenReturn(Observable.just(Resource.success(TestUtils.getWeatherData())))
    }
}