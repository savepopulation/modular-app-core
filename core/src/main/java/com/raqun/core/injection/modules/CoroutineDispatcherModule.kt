package com.raqun.core.injection.modules

import com.raqun.core.coroutines.DefaultDispatcherProvider
import com.raqun.core.coroutines.DispatcherProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoroutineDispatcherModule {

    @Provides
    @Singleton
    fun provideDefaultDispatcher(): DispatcherProvider = DefaultDispatcherProvider()

}