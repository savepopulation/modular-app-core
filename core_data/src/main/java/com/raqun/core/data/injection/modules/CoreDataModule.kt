package com.raqun.core.data.injection.modules

import com.raqun.core.data.adapter.ApiCallAdapter
import com.raqun.core.data.adapter.CallAdapter
import com.raqun.core.data.api.response.ApiResponse
import com.raqun.core.error.ErrorFactory
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Deferred
import javax.inject.Singleton

@Module(includes = [ApiModule::class])
class CoreDataModule {
    @Singleton
    @Provides
    fun provideApiCallAdapter(errorFactory: ErrorFactory): CallAdapter<Deferred<ApiResponse<out Any?>>> =
        ApiCallAdapter(errorFactory)
}