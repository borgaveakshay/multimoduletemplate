package com.example.home.di

import com.example.base.transformers.AsyncTransformer
import com.example.datastore.dao.WeatherDao
import com.example.datastore.datastoreImpl.WeatherDataStoreImpl
import com.example.datastore.mappers.WeatherEntityMapper
import com.example.datastore.store.WeatherDataStore
import com.example.home.data.api.WeatherAPI
import com.example.home.data.repositoriesimpl.GetWeatherRepoImpl
import com.example.home.domain.usecase.GetWeatherUseCase
import com.example.models.GetWeatherResponse
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class HomeModule {

    @Singleton
    @Provides
    fun getDataStore(dao: WeatherDao, mapper: WeatherEntityMapper): WeatherDataStore =
        WeatherDataStoreImpl(dao, mapper)

    @Singleton
    @Provides
    fun getWeatherRepo(api: WeatherAPI, weatherDataStore: WeatherDataStore) =
        GetWeatherRepoImpl(api, weatherDataStore)

    @Singleton
    @Provides
    fun getWeatherApi(retrofit: Retrofit) = retrofit.create(WeatherAPI::class.java)

    @Provides
    fun getAsyncTransformer() = AsyncTransformer<GetWeatherResponse>()

    @Singleton
    @Provides
    fun getWeatherUseCase(
        asyncTransformer: AsyncTransformer<GetWeatherResponse>,
        weatherRepoImpl: GetWeatherRepoImpl
    ) = GetWeatherUseCase(asyncTransformer, weatherRepoImpl)

}