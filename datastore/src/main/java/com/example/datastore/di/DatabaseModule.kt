package com.example.datastore.di

import android.content.Context
import androidx.room.Room
import com.example.datastore.WeatherDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    fun getWeatherDao(database: WeatherDatabase) = database.weatherDao()

    @Singleton
    @Provides
    fun getWeatherDatabase(@ApplicationContext context: Context): WeatherDatabase {
        return Room.databaseBuilder(
            context,
            WeatherDatabase::class.java,
            "weatherdb"
        ).build()
    }
}