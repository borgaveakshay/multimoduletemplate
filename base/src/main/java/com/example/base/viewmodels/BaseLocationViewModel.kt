package com.example.base.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

open class BaseLocationViewModel: ViewModel() {

    val compositeDisposable by lazy { CompositeDisposable() }
    val isLocationPermissionGiven = MutableLiveData<Boolean>()

    override fun onCleared() {
        compositeDisposable.clear()
    }

}

fun BaseLocationViewModel.disposeUseCase(disposable: Disposable) = compositeDisposable.add(disposable)