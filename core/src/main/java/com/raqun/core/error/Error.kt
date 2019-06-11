package com.raqun.core.error

sealed class Error {

    data class UnknownError(val message: String) : Error()

    data class ApiError(val code: Int = 1, val message: String? = null) : Error()

    data class BusinessError(val code: Int = 1, val message: String?) : Error()

    data class InvalidResponseError(val message: String) : Error()

    class AuthenticationError : Error()
}