package com.example.base.utils

import android.view.View
import com.google.android.material.snackbar.Snackbar

object SnackBarUtil {


    fun showLongSnackBar(view: View, message: String) {
        Snackbar.make(
            view,
            message,
            Snackbar.LENGTH_LONG
        ).show()
    }
}