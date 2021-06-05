package com.example.datastore

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.datastore.dao.WeatherDao
import com.example.datastore.entities.WeatherEntity

@Database(entities = arrayOf(WeatherEntity::class), version = 1)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun weatherDao(): WeatherDao
}