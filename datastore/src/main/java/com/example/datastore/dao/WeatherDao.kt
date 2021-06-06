package com.example.datastore.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.datastore.entities.WeatherEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(weatherEntity: WeatherEntity): Completable

    @Query("SELECT * from weatherentity")
    fun getAllWeatherData(): LiveData<List<WeatherEntity>>

    @Query("SELECT * from weatherentity where city_name= :cityName")
    fun getWeatherOfCity(cityName: String): Observable<WeatherEntity>
}