package com.raqun.core.presentation.extensions

import android.annotation.SuppressLint
import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raqun.core.presentation.recyclerview.RecyclerViewAdapter

/*
 * Setups RecyclerView with Default parameters
 */
@SuppressLint("WrongConstant")
fun RecyclerView.setup(
    context: Context,
    orientation: Int = LinearLayoutManager.VERTICAL,
    adapter: RecyclerViewAdapter?
) {
    val layoutManager = LinearLayoutManager(context)
    layoutManager.orientation = orientation
    this.layoutManager = layoutManager
    this.setHasFixedSize(false)
    adapter?.let {
        this.adapter = adapter
    }
}

/*
 * Scrolls to bottom if can
 */
fun RecyclerView.scrollToBottom() {
    if (adapter != null && adapter!!.itemCount > 0) {
        scrollToPosition(adapter!!.itemCount - 1)
    }
}

