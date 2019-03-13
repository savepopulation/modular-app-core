package com.raqun.core.application

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

abstract class CoreApplicationImpl : Application(), CoreApplication {

    @Inject
    lateinit var dispachingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun inject() {
        // override if needed
    }

    override fun onCreate() {
        super.onCreate()
        inject()
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispachingAndroidInjector
}