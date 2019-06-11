package com.raqun.core.injection.modules

import com.raqun.core.date.DateTimeConverter
import com.raqun.core.date.DefaultDateTimeConverter
import com.raqun.core.preconditions.AndroidPreconditions
import com.raqun.core.preconditions.DefaultAndroidPreconditions
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    includes = [CoroutineManagerModule::class,
        CoroutineDispatcherModule::class,
        ErrorFactoryModule::class]
)
class CoreModule {

    @Provides
    @Singleton
    fun provideAndroidPreconditions(): AndroidPreconditions = DefaultAndroidPreconditions()

    @Provides
    @Singleton
    fun provideDateTimeConverter(): DateTimeConverter = DefaultDateTimeConverter()
}