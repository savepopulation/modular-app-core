package com.raqun.core.presentation.extensions

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast

fun Context.alert(message: String, length: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, message, length).show()

@SuppressLint("MissingPermission")
fun Context.isWifiConnected(): Boolean {
    val connManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
    return mWifi.isConnected
}