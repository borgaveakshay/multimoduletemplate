package com.example.base.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

@HiltViewModel
open class BaseLocationViewModel: ViewModel() {

    val compositeDisposable by lazy { CompositeDisposable() }
    val isLocationPermissionGiven = MutableLiveData<Boolean>()

    override fun onCleared() {
        compositeDisposable.clear()
    }

}