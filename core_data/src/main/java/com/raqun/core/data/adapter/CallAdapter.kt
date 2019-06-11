package com.raqun.core.data.adapter

import com.raqun.core.data.api.response.ApiResponse
import com.raqun.core.model.DataHolder
import kotlinx.coroutines.Deferred

interface CallAdapter<T : Any> {
    suspend fun adapt(apiCall: Deferred<ApiResponse<T?>>): DataHolder<T>
}