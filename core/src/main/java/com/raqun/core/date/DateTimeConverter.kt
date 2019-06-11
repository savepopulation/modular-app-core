package com.raqun.core.date

interface DateTimeConverter {

    fun convertLongToDate(dateTime: Long, dateFormat: String = DateTimeConstants.DEFAULT_DATE_FORMAT): String

    fun convertCurrentDateToLong(): Long
}