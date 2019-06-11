package com.raqun.core.error

object DefaultErrorFactory : ErrorFactory {

    override fun createUnknownError(): Error = Error.UnknownError("Unknown error!")

    override fun createApiError(code: Int, message: String?): Error = Error.ApiError(code, message)

    override fun createErrorFromThrowable(t: Throwable): Error = Error.ApiError(message = t.localizedMessage)

    override fun createBusinessError(code: Int, message: String?): Error = Error.BusinessError(code, message)

    override fun createAuthenticationError(): Error = Error.AuthenticationError()

    override fun createInvalidResponseError(): Error = Error.InvalidResponseError("Invalid Response!")

}