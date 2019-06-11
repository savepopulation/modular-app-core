package com.raqun.core.presentation.recyclerview

interface DisplayItemListMapper<T> {
    fun map(items: List<T>): List<DisplayItem>
}