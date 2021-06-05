package com.example.datastore.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WeatherEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "city_name") val cityName: String,
    @ColumnInfo(name = "tempreture") val temp: Double
)
