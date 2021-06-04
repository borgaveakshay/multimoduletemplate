package com.example.home.domain.usecase

import com.example.base.usecase.BaseUseCase
import com.example.base.utils.Transformer
import com.example.home.data.models.GetWeatherRequest
import com.example.home.data.models.GetWeatherResponse
import com.example.home.domain.repository.GetWeatherRepository
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    transformer: Transformer<GetWeatherResponse>,
    private val repository: GetWeatherRepository
) : BaseUseCase<GetWeatherResponse, GetWeatherRequest>(transformer) {
    override fun createObservable(request: GetWeatherRequest?) = repository.getWeather(request!!)
}