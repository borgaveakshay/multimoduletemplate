package com.example.home.domain.usecase

import com.example.base.utils.TestTransformer
import com.example.home.domain.repository.GetWeatherRepository
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.mockito.Matchers.any
import org.mockito.Mockito

class GetWeatherUseCaseTest : TestCase() {

    lateinit var repository: GetWeatherRepository
    lateinit var useCase: GetWeatherUseCase

     @Before
     fun before() {
         repository = Mockito.mock(GetWeatherRepository::class.java)
         useCase = GetWeatherUseCase(TestTransformer(), repository)
     }

    @Test
    fun when_get_whether_response_is_success() {
        // GIVEN

        // WHEN

        // THEN
    }

    private fun givenSuccessfulResponse() {
        Mockito.`when`(repository.getWeather(any()))
    }
}