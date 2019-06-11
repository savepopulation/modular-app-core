package com.raqun.core.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

open class DefaultCoroutineManager(override val coroutineContext: CoroutineContext) : CoroutineManager {

    protected val coroutinesJobs: MutableList<Job> by lazy {
        mutableListOf<Job>()
    }

    override fun handleLaunch(execution: suspend CoroutineScope.() -> Unit) {
        val job: Job = launch { execution() }
        coroutinesJobs.add(job)
        job.invokeOnCompletion { coroutinesJobs.remove(job) }
    }

    @Synchronized
    override fun handleLaunch(
        execution: suspend CoroutineScope.() -> Unit,
        error: suspend CoroutineScope.(Throwable) -> Unit,
        handleCancellationExceptionManually: Boolean
    ) {
        launch { tryCatch(execution, error, handleCancellationExceptionManually) }
    }

    @Synchronized
    override fun handleLaunch(
        execution: suspend CoroutineScope.() -> Unit,
        error: suspend CoroutineScope.(Throwable) -> Unit,
        final: suspend CoroutineScope.() -> Unit,
        handleCancellationExceptionManually: Boolean
    ) {
        launch { tryCatchFinally(execution, error, final, handleCancellationExceptionManually) }
    }

    @Synchronized
    override fun handleLaunch(
        execution: suspend CoroutineScope.() -> Unit,
        final: suspend CoroutineScope.() -> Unit,
        suppressCancellationException: Boolean
    ) {
        launch { tryFinally(execution, final, suppressCancellationException) }
    }

    @Synchronized
    override fun cancelAllCoroutines() {
        val coroutinesJobsSize = coroutinesJobs.size

        if (coroutinesJobsSize > 0) {
            for (i in coroutinesJobsSize - 1 downTo 0) {
                coroutinesJobs[i].cancel()
            }
        }
    }

    @Synchronized
    override fun destroy() {
        cancelAllCoroutines()
    }
}