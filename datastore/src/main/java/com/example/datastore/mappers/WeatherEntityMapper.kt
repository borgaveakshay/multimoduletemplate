package com.example.datastore.mappers

import com.example.base.utils.Mapper
import com.example.datastore.entities.WeatherEntity
import com.example.models.GetWeatherResponse

class WeatherEntityMapper : Mapper<WeatherEntity, GetWeatherResponse>() {
    override fun mapFrom(from: WeatherEntity) = GetWeatherResponse(from.cityName, from.temp)
}