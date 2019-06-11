package com.raqun.core.presentation.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var itemClickListener: ((item: DisplayItem) -> Unit)? = null
    var itemLongClickListener: ((item: DisplayItem) -> Boolean)? = null
}