package com.raqun.core.presentation.extensions

import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.snackbar.Snackbar

fun CoordinatorLayout.snackThat(
    meesage: CharSequence,
    buttonText: CharSequence,
    singleShot: View.OnClickListener?,
    length: Int = Snackbar.LENGTH_INDEFINITE
) {
    val sb = Snackbar.make(this, meesage, length)
    if (singleShot != null) {
        sb.setAction(buttonText, singleShot)
        sb.dismiss()
    } else {
        sb.setAction(buttonText) { sb.dismiss() }
    }
    sb.show()
}

fun CoordinatorLayout.snackThat(
    meesage: CharSequence,
    length: Int = Snackbar.LENGTH_SHORT
) {
    val sb = Snackbar.make(this, meesage, length)
    sb.show()
}