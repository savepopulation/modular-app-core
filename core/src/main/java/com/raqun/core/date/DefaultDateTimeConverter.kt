package com.raqun.core.date

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

class DefaultDateTimeConverter : DateTimeConverter {

    @SuppressLint("SimpleDateFormat")
    override fun convertLongToDate(dateTime: Long, dateFormat: String): String {
        val sdf = SimpleDateFormat(dateFormat)
        val date = Date(dateTime)
        return sdf.format(date)
    }

    override fun convertCurrentDateToLong(): Long = Date().time

}