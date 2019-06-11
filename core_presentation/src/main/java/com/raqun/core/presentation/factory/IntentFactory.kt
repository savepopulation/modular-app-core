package com.raqun.core.presentation.factory

import android.content.Context
import android.content.Intent
import java.lang.ref.WeakReference

interface IntentFactory {

    val context: WeakReference<Context>

    fun createOpenLinkIntent(url: String): Intent?

    fun createShareIntent(packageName: String): Intent?

    fun createShareTextIntent(shareBody: String, title: String): Intent

    fun createSettingsIntent(): Intent

    fun createGoogleMapsIntent(lat: Double, lng: Double): Intent?
}