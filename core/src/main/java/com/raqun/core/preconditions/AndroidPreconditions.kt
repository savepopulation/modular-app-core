package com.raqun.core.preconditions

interface AndroidPreconditions {
    fun assertMainThread()

    fun assertUiThread()

    fun assertWorkerThread()
}