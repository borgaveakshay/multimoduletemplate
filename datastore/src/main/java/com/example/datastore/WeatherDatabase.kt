package com.example.datastore

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.datastore.dao.WeatherDao
import com.example.datastore.entities.WeatherEntity

@Database(entities = [WeatherEntity::class], version = 1, exportSchema = false)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun weatherDao(): WeatherDao
}