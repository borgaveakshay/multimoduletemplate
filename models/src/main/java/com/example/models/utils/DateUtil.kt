package com.example.models.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

private const val DATE_FORMAT = "dd/MM/yyyy"

object DateUtil {

    @SuppressLint("SimpleDateFormat")
    fun getAbbreviatedFromDateTime(date: Long): String {
        val simpleDateFormat = SimpleDateFormat(DATE_FORMAT)
        return simpleDateFormat.format(Date(date))
    }

}