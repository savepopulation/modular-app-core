package com.raqun.core.injection.modules

import com.raqun.core.coroutines.*
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class CoroutineManagerModule {

    @Provides
    @Singleton
    @Named(AM_NAME_INTERACTOR)
    fun provideAsyncManagerForInteractors(dispatcherProvider: DispatcherProvider): AsyncManager =
        DefaultAsyncManager(dispatcherProvider.default())

    @Provides
    @Singleton
    @Named(AM_NAME_REPOSITORY)
    fun provideAsyncManagerForRepositories(dispatcherProvider: DispatcherProvider): AsyncManager =
        DefaultAsyncManager(dispatcherProvider.io())

    @Provides
    @Singleton
    @Named(AM_NAME_REMOTE_DATA_SOURCE)
    fun provideAsyncManagerForRemoteDataSources(dispatcherProvider: DispatcherProvider): AsyncManager =
        DefaultAsyncManager(dispatcherProvider.io())

    @Provides
    @Singleton
    @Named(CM_VIEWMODEL)
    fun provideCoroutineManagerForViewModel(dispatcherProvider: DispatcherProvider): CoroutineManager =
        DefaultCoroutineManager(dispatcherProvider.ui())


    companion object {
        const val AM_NAME_INTERACTOR = "am_interactor"
        const val AM_NAME_REPOSITORY = "am_repository"
        const val CM_VIEWMODEL = "cm_viewmodel"
        const val AM_NAME_REMOTE_DATA_SOURCE = "am_remote_datasource"
    }
}