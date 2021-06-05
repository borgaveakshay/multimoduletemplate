package com.example.datastore.dao

import io.reactivex.rxjava3.core.Observable
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

    @Query("SELECT * from weatherentity where city_name= :cityName")
    fun getWeatherOfCity(cityName: String): Observable<WeatherEntity>
}