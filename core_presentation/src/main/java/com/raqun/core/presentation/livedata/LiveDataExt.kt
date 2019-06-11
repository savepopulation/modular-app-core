package com.raqun.core.presentation.livedata

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.raqun.core.model.DataHolder
import com.raqun.core.presentation.base.BaseView
import com.raqun.core.presentation.entity.ViewEntity

inline fun <T : ViewEntity> LiveData<DataHolder<T>>.observeApi(
    lifecycleOwner: LifecycleOwner,
    crossinline body: (DataHolder<T>?) -> Unit
) {
    observe(lifecycleOwner, Observer { bean: DataHolder<T>? ->
        if (bean is DataHolder.Fail) {
            if (lifecycleOwner is BaseView) {
                lifecycleOwner.onError(bean.e)
            }
        }
        body(bean)
    })
}