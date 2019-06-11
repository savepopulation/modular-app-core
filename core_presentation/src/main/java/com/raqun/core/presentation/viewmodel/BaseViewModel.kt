package com.raqun.core.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.raqun.core.coroutines.CoroutineManager
import com.raqun.core.model.DataHolder

abstract class BaseViewModel constructor(coroutineManager: CoroutineManager) : ViewModel(),
    CoroutineManager by coroutineManager {

    private val _errorLiveData = SingleLiveData<DataHolder.Fail>()

    val errorLiveData: MutableLiveData<DataHolder.Fail>
        get() = _errorLiveData

    override fun onCleared() {
        destroy()
        super.onCleared()
    }
}