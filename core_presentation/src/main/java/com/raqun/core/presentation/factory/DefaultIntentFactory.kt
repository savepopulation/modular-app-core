package com.raqun.core.presentation.factory

import android.content.Context
import android.content.Intent
import android.net.Uri
import java.lang.ref.WeakReference

class DefaultIntentFactory(override val context: WeakReference<Context>) :
    IntentFactory {

    override fun createShareIntent(packageName: String): Intent? = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=$packageName")
    }

    override fun createOpenLinkIntent(url: String): Intent? {
        context.get()?.let {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            return if (intent.resolveActivity(context.get()!!.packageManager) != null) intent else null
        }

        return null
    }

    override fun createShareTextIntent(shareBody: String, title: String): Intent {
        return Intent(Intent.ACTION_SEND)
            .apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, shareBody)
            }.also {
                Intent.createChooser(it, title)
            }
    }

    override fun createSettingsIntent() = Intent(android.provider.Settings.ACTION_SETTINGS)

    override fun createGoogleMapsIntent(lat: Double, lng: Double): Intent? {
        val uri =
            "http://maps.google.com/maps?q=$lat,$lng"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        return if (intent.resolveActivity(context.get()!!.packageManager) != null) intent else null
    }
}