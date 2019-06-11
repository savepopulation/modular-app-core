package com.raqun.core.presentation.util

import android.Manifest.permission.*
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat

class PermissionUtil {

    companion object {
        /*
         * Permissions
         */
        val cameraPermissions = arrayOf(CAMERA, WRITE_EXTERNAL_STORAGE)

        val galleryPermissions = arrayOf(READ_EXTERNAL_STORAGE)

        val locationPermissions = arrayOf(ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION)

        val connectionPermissions = arrayOf(ACCESS_WIFI_STATE, ACCESS_NETWORK_STATE)

        val storagePermissions = arrayOf(READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE)

        /*
         * Permission check methods
         */
        fun isCameraPermissionsGranted(context: Context) = cameraPermissions.isPermissionsGranted(context)

        fun isGalleryPermissionsGranted(context: Context) = galleryPermissions.isPermissionsGranted(context)

        fun isLocationPermissionsGranted(context: Context) = locationPermissions.isPermissionsGranted(context)

        fun isConnectionPermissionsGranted(context: Context) = connectionPermissions.isPermissionsGranted(context)

        fun isStoragePermissionGranted(context: Context) = storagePermissions.isPermissionsGranted(context)

        fun isPermissionResultsGranted(grantResult: IntArray) =
            grantResult.none { it != PackageManager.PERMISSION_GRANTED }
    }
}

/*
 * Permission check extension
 */
private fun Array<String>.isPermissionsGranted(context: Context): Boolean {
    for (i in this.indices) {
        if (ActivityCompat.checkSelfPermission(context, this[i]) != PackageManager.PERMISSION_GRANTED) {
            return false
        }
    }
    return true
}