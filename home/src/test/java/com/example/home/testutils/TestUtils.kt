package com.example.home.testutils

import com.example.models.*


object TestUtils {

    fun getWeatherData() = GetWeatherResponse(
            0,
            0,
            Main(230.0, 240.5, 250, 248, 222.5, 222.8),
            Clouds(1),
            Sys("IN", 10, 1, 111111, 12, 0.0),
            0,
            Coord(1000.0, 11111.0),
            emptyList(),
            "",
            0,
            0,
            "",
            Wind(0, 0.0),"Pune", "22/02/2021"

    )
}