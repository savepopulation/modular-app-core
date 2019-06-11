package com.raqun.core.coroutines

import android.support.annotation.CallSuper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlin.coroutines.CoroutineContext

open class DefaultAsyncManager(
    override val coroutineContext: CoroutineContext
) : AsyncManager {

    private val deferredObjects: MutableList<Deferred<*>> by lazy {
        mutableListOf<Deferred<*>>()
    }

    @CallSuper
    @Synchronized
    override suspend fun <T> handleAsync(block: suspend CoroutineScope.() -> T): Deferred<T> {
        val deferred: Deferred<T> = async { block() }
        deferredObjects.add(deferred)
        deferred.invokeOnCompletion { deferredObjects.remove(deferred) }
        return deferred
    }

    @CallSuper
    @Synchronized
    override suspend fun <T> handleAsyncAwait(block: suspend CoroutineScope.() -> T): T {
        return handleAsync(block).await()
    }

    @CallSuper
    @Synchronized
    override fun cancelAllAsync() {
        val deferredObjectsSize = deferredObjects.size
        if (deferredObjectsSize > 0) {
            for (i in deferredObjectsSize - 1 downTo 0) {
                deferredObjects[i].cancel()
            }
        }
    }

    @CallSuper
    @Synchronized
    override fun destroy() {
        cancelAllAsync()
    }
}