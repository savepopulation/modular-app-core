package com.raqun.core.preconditions

class DefaultAndroidPreconditions : AndroidPreconditions {

    override fun assertMainThread() {
        if (!Thread.currentThread().isMainThread()) {
            throw IllegalStateException("This code must be executed in main thread!")
        }
    }

    override fun assertUiThread() {
        if (!Thread.currentThread().isMainThread()) {
            throw IllegalStateException("This code must be executed in ui thread!")
        }
    }

    override fun assertWorkerThread() {
        if (Thread.currentThread().isMainThread()) {
            throw IllegalStateException("This code must be executed in worker thread!")
        }
    }

}