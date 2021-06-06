package com.example.home.di

import android.app.Application
import com.example.base.di.RetrofitModule
import com.example.base.transformers.AsyncTransformer
import com.example.datastore.datastoreImpl.WeatherDataStoreImpl
import com.example.home.data.api.WeatherAPI
import com.example.home.data.repositoriesimpl.GetWeatherRepoImpl
import com.example.home.domain.usecase.GetWeatherUseCase
import com.example.home.presentation.viewmodels.HomeViewModel
import com.example.models.GetWeatherResponse
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class HomeModule {

    @Singleton
    @Provides
    fun getWeatherRepo(api: WeatherAPI, weatherDataStoreImpl: WeatherDataStoreImpl) =
        GetWeatherRepoImpl(api, weatherDataStoreImpl)

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