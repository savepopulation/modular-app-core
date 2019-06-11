package com.raqun.core.data.adapter

import com.raqun.core.data.api.response.ApiResponse
import com.raqun.core.error.ErrorFactory
import com.raqun.core.model.DataHolder
import kotlinx.coroutines.Deferred
import javax.inject.Inject

class ApiCallAdapter<T : Any> @Inject constructor(private val errorFactory: ErrorFactory) : CallAdapter<T> {

    override suspend fun adapt(apiCall: Deferred<ApiResponse<T?>>): DataHolder<T> {
        val apiResult = apiCall.await()

        if (apiResult.code > 0) {
            val error = errorFactory.createApiError(apiResult.code, apiResult.message)
            return DataHolder.Fail(error)
        }

        if (apiResult.data == null) {
            return DataHolder.Fail(errorFactory.createInvalidResponseError())
        }

        return DataHolder.Success(apiResult.data)
    }
}