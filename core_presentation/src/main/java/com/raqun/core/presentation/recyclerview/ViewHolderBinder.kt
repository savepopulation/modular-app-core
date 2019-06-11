package com.raqun.core.presentation.recyclerview

import androidx.recyclerview.widget.RecyclerView

interface ViewHolderBinder {
    fun bind(holder: RecyclerView.ViewHolder, item: DisplayItem)
}