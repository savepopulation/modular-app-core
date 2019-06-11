package com.raqun.core.domain

import com.raqun.core.coroutines.AsyncManager

abstract class BaseInteractor constructor(asyncManager: AsyncManager) : AsyncManager by asyncManager