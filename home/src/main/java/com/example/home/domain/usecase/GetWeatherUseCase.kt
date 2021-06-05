package com.example.home.domain.usecase

import com.example.base.usecase.BaseUseCase
import com.example.base.utils.Transformer
import com.example.home.domain.repository.GetWeatherRepository
import com.example.models.request.GetWeatherRequest
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    transformer: Transformer<com.example.models.GetWeatherResponse>,
    private val repository: GetWeatherRepository
) : BaseUseCase<com.example.models.GetWeatherResponse, GetWeatherRequest>(transformer) {
    override fun createObservable(request: GetWeatherRequest?) = repository.getWeather(request)
}