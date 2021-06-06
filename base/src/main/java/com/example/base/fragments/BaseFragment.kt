package com.example.base.fragments

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.base.R
import com.example.base.viewmodels.BaseLocationViewModel
import com.google.android.gms.location.LocationServices


abstract class BaseFragment<V : ViewModel, B : ViewDataBinding> : Fragment() {

    protected var viewBinding: B? = null
    var location: Location? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(requireContext()),
            getLayoutId(),
            null,
            false
        ) as B
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkLocationPermission()
    }


    private fun checkLocationPermission() {
        when {
            ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED -> {
                // Permission is granted
                getViewModel().isLocationPermissionGiven.value = true
                location = getCurrentLocation()


            }
            ActivityCompat.shouldShowRequestPermissionRationale(
                requireActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) -> showAlertForPermission()

            else -> requestPermission()
        }
    }

    private fun showAlertForPermission() {
        AlertDialog.Builder(requireContext())
            .setPositiveButton(R.string.allow_label) { _, _ ->
                requestPermission()
            }.setNegativeButton(R.string.cancel_label) { _, _ ->
                getViewModel().isLocationPermissionGiven.value = false
            }
            .setTitle(R.string.location_permission_label)
            .setMessage(R.string.location_permission_request_label)
            .show()
    }

    private fun requestPermission() {
        requireActivity().registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            getViewModel().isLocationPermissionGiven.value = it
        }
    }

    @SuppressLint("MissingPermission")
    fun getCurrentLocation(): Location? {
        val locationClient = LocationServices.getFusedLocationProviderClient(requireContext())
        return locationClient.lastLocation.result
    }

    abstract fun getViewModel(): BaseLocationViewModel

    abstract fun getLayoutId(): Int

}