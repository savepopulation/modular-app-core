package com.raqun.core.data.api.response

data class ApiResponse<T>(val code: Int = 0, val message: String?, val data: T?)