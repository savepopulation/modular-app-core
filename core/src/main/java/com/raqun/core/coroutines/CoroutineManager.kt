package com.raqun.core.coroutines

import kotlinx.coroutines.CoroutineScope

interface CoroutineManager : CoroutineScope {

    fun handleLaunch(execution: suspend CoroutineScope.() -> Unit)

    fun handleLaunch(
        execution: suspend CoroutineScope.() -> Unit,
        error: suspend CoroutineScope.(Throwable) -> Unit,
        handleCancellationExceptionManually: Boolean = false
    )

    fun handleLaunch(
        execution: suspend CoroutineScope.() -> Unit,
        error: suspend CoroutineScope.(Throwable) -> Unit,
        final: suspend CoroutineScope.() -> Unit,
        handleCancellationExceptionManually: Boolean = false
    )

    fun handleLaunch(
        execution: suspend CoroutineScope.() -> Unit,
        final: suspend CoroutineScope.() -> Unit,
        suppressCancellationException: Boolean = false
    )

    fun cancelAllCoroutines()

    fun destroy()
}