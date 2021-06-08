package com.example.home.presentation.viewmodels

import android.app.Application
import android.location.Address
import android.location.Geocoder
import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.base.viewmodels.BaseLocationViewModel
import com.example.datastore.store.WeatherDataStore
import com.example.home.R
import com.example.home.domain.usecase.GetWeatherUseCase
import com.example.models.GetWeatherResponse
import com.example.models.request.GetWeatherRequest
import com.example.models.response.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.IOException
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val context: Application,
    private val weatherUseCase: GetWeatherUseCase,
    private val dataStore: WeatherDataStore
) : BaseLocationViewModel() {

    val saveClicked = MutableLiveData<Unit>()

    fun onSaveClicked() = saveClicked.postValue(Unit)

    fun getWeatherUpdate(currentLocation: Location): LiveData<Resource<List<GetWeatherResponse>>> {
        val liveData = MutableLiveData<Resource<List<GetWeatherResponse>>>()
        liveData.postValue(Resource.loading(null))

        getCityFromLocation(currentLocation)?.let {
            liveData.postValue(Resource.loading(null))
            compositeDisposable.add(dataStore.getWeather(it).subscribe { response ->
                liveData.postValue(Resource.success(response))
            })
            compositeDisposable.add(weatherUseCase.invoke(GetWeatherRequest(it)).subscribe())
        } ?: liveData.postValue(
            Resource.error(
                null,
                context.getString(R.string.weather_not_available)
            )
        )

        return liveData
    }


    private fun getCityFromLocation(location: Location?): String? {
        var cityName: String? = null
        location?.let {
            val gcd = Geocoder(context, Locale.getDefault())
            try {
                val addresses: List<Address> =
                    gcd.getFromLocation(location.latitude, location.longitude, 1)
                if (addresses.isNotEmpty()) {
                    cityName = addresses[0].locality
                }
            } catch (e: IOException) {
                cityName = null
            }
        }
        return cityName
    }

}