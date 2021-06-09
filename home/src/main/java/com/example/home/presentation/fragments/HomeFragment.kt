package com.example.home.presentation.fragments

import android.location.Location
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.base.fragments.BaseFragment
import com.example.base.utils.SnackBarUtil
import com.example.home.R
import com.example.home.databinding.HomeFragmentBinding
import com.example.home.presentation.adapters.WeatherListAdapter
import com.example.home.presentation.viewmodels.HomeViewModel
import com.example.models.response.Status
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
            } else
                SnackBarUtil.showLongSnackBar(
                    requireView(),
                    getString(R.string.weather_not_available)
                )
        }
        getViewModel().saveClicked.observe(viewLifecycleOwner, Observer {
            checkLocationAndUpdate()
        })

        viewBinding?.let {
            with(it) {
                viewModel = homeViewModel
                weatherList.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                weatherList.adapter = adapter
            }
        }
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

                        resource.data?.let { list ->
                            if (list.isEmpty()) SnackBarUtil.showLongSnackBar(
                                requireView(),
                                getString(R.string.weather_not_available)
                            )
                            else {
                                adapter.updateList(list)
                                SnackBarUtil.showLongSnackBar(
                                    requireView(),
                                    getString(R.string.weather_updated)
                                )
                            }
                        }
                    }
                }
                Status.ERROR -> SnackBarUtil.showLongSnackBar(
                    requireView(),
                    resource.errorMessage.toString()
                )
                Status.LOADING -> SnackBarUtil.showLongSnackBar(
                    requireView(),
                    getString(R.string.weather_loading)
                )
            }
        }
    }
}