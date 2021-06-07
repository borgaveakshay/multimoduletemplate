package com.example.datastore.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "weather", indices = [Index(value = ["city_name"], unique = true)])

data class WeatherEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "city_name") val cityName: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "tempreture") val temp: Double,
    @ColumnInfo(name = "country") val country: String
)
