package com.raqun.core.data.datasource

import com.raqun.core.model.DataHolder
import kotlinx.coroutines.Deferred

interface DataSource {

    interface Remote<Req, Res : Any> : DataSource {
        suspend fun getResult(request: Req): Deferred<DataHolder<Res>>
    }

    interface Local<K, V> : DataSource {
        fun get(key: K): V?

        fun get(page: Int): List<V>

        fun getAll(): List<V>

        fun put(key: K?, data: V): Boolean

        fun remove(value: V): Boolean

        fun removeByKey(key: K): Boolean

        fun clear()
    }

    interface Cache<KEY, VALUE> : DataSource {
        fun get(key: KEY): VALUE?

        fun put(key: KEY, value: VALUE): Boolean

        fun drop()
    }

}