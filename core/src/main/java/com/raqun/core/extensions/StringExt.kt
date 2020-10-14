package com.raqun.core.extensions

import java.net.MalformedURLException
import java.net.URL

fun String.isUrl(): Boolean {
    return try {
        URL(this)
        true
    } catch (e: MalformedURLException) {
        false
    }
}
