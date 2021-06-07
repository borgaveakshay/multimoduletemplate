package com.example.datastore.dao

import androidx.room.*
import com.example.datastore.entities.WeatherEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface WeatherDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(weatherEntity: WeatherEntity): Completable


    @Query("SELECT * from weatherentity")
    fun getAllWeatherData(): Observable<List<WeatherEntity>>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(userEntity: WeatherEntity): Completable

    @Query("SELECT * from weatherentity where city_name= :cityName")
    fun getWeatherOfCity(cityName: String): Observable<WeatherEntity>
}