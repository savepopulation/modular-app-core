package com.raqun.core.domain

import com.raqun.core.model.DataHolder
import kotlinx.coroutines.Deferred

interface Interactor {

    interface DeferredInteractor<P : Params, T : Any> : Interactor {
        suspend fun execute(params: P?): Deferred<DataHolder<T>>
    }

    abstract class Params {
        // marker class
    }
}