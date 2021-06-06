package com.example.home.presentation.viewmodels

import android.app.Application
import android.location.Address
import android.location.Geocoder
import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.base.viewmodels.BaseLocationViewModel
import com.example.home.domain.usecase.GetWeatherUseCase
import com.example.models.GetWeatherResponse
import com.example.models.request.GetWeatherRequest
import com.example.models.response.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val context: Application,
    private val weatherUseCase: GetWeatherUseCase
) : BaseLocationViewModel() {


    fun getWeatherUpdate(currentLocation: Location): LiveData<Resource<GetWeatherResponse>> {
        val liveData = MutableLiveData<Resource<GetWeatherResponse>>()
        getCityFromLocation(currentLocation)?.let {
            val disposable = weatherUseCase.invoke(GetWeatherRequest(it)).subscribe({ response ->
                liveData.postValue(Resource.success(response))
            }, { error ->
                liveData.postValue(Resource.error(null, error.message))
            })

            compositeDisposable.add(disposable)
        }
        return liveData
    }


    private fun getCityFromLocation(location: Location): String? {
        var cityName: String? = null
        val gcd = Geocoder(context, Locale.getDefault())
        val addresses: List<Address> = gcd.getFromLocation(location.latitude, location.longitude, 1)
        if (addresses.isNotEmpty()) {
            cityName = addresses[0].locality
        }

        return cityName
    }

}