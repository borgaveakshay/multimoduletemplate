package com.example.datastore.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.datastore.entities.WeatherEntity

@Dao
interface WeatherDao {

    @Insert
    fun insert(weatherEntity: WeatherEntity): Long

    @Query("SELECT * from weatherentity")
    fun getAllWeatherData(): LiveData<List<WeatherEntity>>
}