package com.raqun.core.injection.modules

import com.raqun.core.error.DefaultErrorFactory
import com.raqun.core.error.ErrorFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ErrorFactoryModule {

    @Provides
    @Singleton
    internal fun provideErrorFactory(): ErrorFactory =
        DefaultErrorFactory

}