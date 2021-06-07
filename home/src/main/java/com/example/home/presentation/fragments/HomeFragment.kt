package com.example.home.presentation.fragments

import android.location.Location
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import com.example.base.fragments.BaseFragment
import com.example.home.R
import com.example.home.databinding.HomeFragmentBinding
import com.example.home.presentation.adapters.WeatherListAdapter
import com.example.home.presentation.viewmodels.HomeViewModel
import com.example.models.response.Status
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel, HomeFragmentBinding>() {

    private val homeViewModel: HomeViewModel by viewModels()
    private val adapter by lazy { WeatherListAdapter() }

    override fun getViewModel() = homeViewModel
    override fun getLayoutId() = R.layout.home_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getViewModel().isLocationPermissionGiven.observe(viewLifecycleOwner) { locationAvailable ->
            if (locationAvailable) {
                checkLocationAndUpdate()
            }
        }
        getViewModel().saveClicked.observe(viewLifecycleOwner, Observer {
            checkLocationAndUpdate()
        })
    }

    private fun checkLocationAndUpdate() {
        location?.let {
            getWeatherUpdate(it)
        }
    }

    private fun getWeatherUpdate(location: Location) {
        getViewModel().getWeatherUpdate(location).observe(viewLifecycleOwner) { resource ->
            when (resource.status) {
                Status.SUCCESS -> {
                    viewBinding?.let {
                        with(it) {
                            weatherList.adapter = adapter
                            resource.data?.let { list ->
                                adapter.updateList(list)
                                Snackbar.make(
                                    requireView(),
                                    getString(R.string.weather_updated),
                                    Snackbar.LENGTH_LONG
                                ).show()
                            }
                        }
                    }
                }
                Status.ERROR -> Snackbar.make(
                    requireView(),
                    resource.errorMessage.toString(),
                    Snackbar.LENGTH_LONG
                ).show()
                Status.LOADING -> Snackbar.make(
                    requireView(),
                    "loading Weather...",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }
    }
}