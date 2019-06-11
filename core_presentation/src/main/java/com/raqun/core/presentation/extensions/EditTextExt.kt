package com.raqun.core.presentation.extensions

import android.content.Context
import android.text.TextUtils
import android.widget.EditText

/*
 * Pastse from clipboard
 */
fun EditText.pasteFromClipBoard() {
    var text = ""
    val currentSdk = android.os.Build.VERSION.SDK_INT
    if (currentSdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
        val manager: android.text.ClipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE)
                as android.text.ClipboardManager
        try {
            text = manager.text.toString()
        } catch (e: Exception) {
            // ignored
        }
    } else {
        val manager: android.content.ClipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE)
                as android.content.ClipboardManager
        manager.primaryClip?.let {
            val item = manager.primaryClip?.getItemAt(0)
            text = item?.text.toString()
        }
    }

    if (!TextUtils.isEmpty(text)) setText(text)
}