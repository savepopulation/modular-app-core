package com.raqun.core.presentation.entity

interface ViewEntityMapper<R, T : ViewEntity> {
    fun map(value: R): T
}