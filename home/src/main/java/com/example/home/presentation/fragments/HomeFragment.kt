package com.example.home.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.base.fragments.BaseFragment
import com.example.home.R
import com.example.home.databinding.HomeFragmentBinding
import com.example.home.presentation.viewmodels.HomeViewModel
import com.example.models.response.Status
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel, HomeFragmentBinding>() {

    private val homeViewModel: HomeViewModel by viewModels()


    override fun getViewModel() = homeViewModel
    override fun getLayoutId() = R.layout.home_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getViewModel().isLocationPermissionGiven.observe(viewLifecycleOwner, { locationAvailable ->
            if (locationAvailable) {
                location?.let {
                    getViewModel().getWeatherUpdate(it).observe(viewLifecycleOwner, { resource ->
                        when (resource.status) {
                            Status.SUCCESS -> viewBinding?.weather = resource.data
                            Status.ERROR -> Snackbar.make(
                                view,
                                resource.errorMessage.toString(),
                                Snackbar.LENGTH_LONG
                            ).show()
                            Status.LOADING -> Snackbar.make(
                                view,
                                "loading Weather...",
                                Snackbar.LENGTH_LONG
                            ).show()
                        }
                    })
                }
            }
        })
    }


}