package com.raqun.core.presentation.base

import android.content.Context
import androidx.annotation.CallSuper
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector

abstract class BaseInjectionFragment : BaseFragment() {

    @CallSuper
    override fun onAttach(context: Context?) {
        if (activity is HasSupportFragmentInjector) {
            AndroidSupportInjection.inject(this)
            onInject()
        }
        super.onAttach(context)
    }

    open fun onInject() {
        // empty for override
    }
}