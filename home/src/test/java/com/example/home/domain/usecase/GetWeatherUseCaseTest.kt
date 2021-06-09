package com.example.home.domain.usecase

import com.example.base.transformers.TestTransformer
import com.example.home.domain.repository.GetWeatherRepository
import com.example.home.testutils.TestUtils
import com.example.models.GetWeatherResponse
import com.example.models.request.GetWeatherRequest
import com.example.models.response.Resource
import com.example.models.response.Status
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


    @Test
    fun when_get_whether_response_is_unsuccessful() {
        // GIVEN
        val e = Exception("error")
        givenUnsuccessfulResponse(e)

        // WHEN
        val result = useCase(request).test()

        // THEN
        result.assertValue {
            it.status === Status.ERROR
            it.errorMessage === e.message
        }
    }


    private fun givenSuccessfulResponse() {
        Mockito.`when`(repository.getWeather(request))
            .thenReturn(Observable.just(Resource.success(TestUtils.getWeatherData())))
    }

    private fun givenUnsuccessfulResponse(e: Exception) {
        Mockito.`when`(repository.getWeather(request))
            .thenReturn(Observable.just(Resource.error(GetWeatherResponse(), e.message)))
    }
}