package com.raqun.core.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred

interface AsyncManager : CoroutineScope {

    suspend fun <T> handleAsync(block: suspend CoroutineScope.() -> T): Deferred<T>

    suspend fun <T> handleAsyncAwait(block: suspend CoroutineScope.() -> T): T

    fun cancelAllAsync()

    fun destroy()
}