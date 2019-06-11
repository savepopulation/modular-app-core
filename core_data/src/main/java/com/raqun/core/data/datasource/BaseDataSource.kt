package com.raqun.core.data.datasource

import com.raqun.core.coroutines.AsyncManager

abstract class BaseDataSource(asyncManager: AsyncManager) : AsyncManager by asyncManager