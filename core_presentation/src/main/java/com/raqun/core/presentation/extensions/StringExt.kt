package com.raqun.core.presentation.extensions

import android.content.Context

fun String?.toClipBoard(label: String? = null, context: Context) {
    if (this != null) {
        val currentSdk = android.os.Build.VERSION.SDK_INT

        if (currentSdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
            val manager: android.text.ClipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE)
                    as android.text.ClipboardManager
            manager.text = this
        } else {
            val manager: android.content.ClipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE)
                    as android.content.ClipboardManager
            manager.primaryClip = android.content.ClipData.newPlainText(label, this)
        }
    }
}