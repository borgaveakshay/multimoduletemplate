package com.example.datastore

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.datastore.dao.WeatherDao
import com.example.datastore.entities.WeatherEntity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
class WeatherDataStoreImplTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    lateinit var dao: WeatherDao
    lateinit var db: WeatherDatabase

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context,
            WeatherDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = db.weatherDao()
    }

    @Test
    fun when_record_is_added_successfully() {
        //GIVEN
        val date = Calendar.getInstance()
        date.set(2021, 4, 26)
        val entity = WeatherEntity(0, "Pune", date.timeInMillis, 30.0)

        //WHEN
        dao.insert(entity).blockingAwait()

        //THEN
        val weather = dao.getWeatherOfCity("Pune")
        weather.test().assertValue {
            it.cityName === entity.cityName
            it.temp == entity.temp
        }
    }


    @After
    fun tearDown() {
        db.close()
    }
}