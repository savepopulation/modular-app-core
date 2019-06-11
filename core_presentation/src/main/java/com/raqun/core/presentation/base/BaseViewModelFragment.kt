package com.raqun.core.presentation.base

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.raqun.core.presentation.viewmodel.BaseViewModel
import javax.inject.Inject

abstract class BaseViewModelFragment<VM : ViewModel> : BaseInjectionFragment() {

    @Inject
    protected lateinit var vmFactory: ViewModelProvider.Factory

    protected lateinit var viewModel: VM

    abstract fun getModelClass(): Class<VM>

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, vmFactory).get(getModelClass())
    }

    @CallSuper
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (viewModel is BaseViewModel) {
            (viewModel as BaseViewModel).errorLiveData.observe(this, Observer {
                onError(it.e)
            })
        }
    }
}