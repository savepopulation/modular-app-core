package com.raqun.core.presentation.recyclerview

import androidx.recyclerview.widget.DiffUtil

class DiffUtilImpl(
    private val oldItems: List<DisplayItem>,
    private val newItems: List<DisplayItem>,
    private val comparator: DisplayItemComperator
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        comparator.areItemsSame(oldItems[oldItemPosition], newItems[newItemPosition])

    override fun getOldListSize() = oldItems.size

    override fun getNewListSize() = newItems.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        comparator.areContentsSame(oldItems[oldItemPosition], newItems[newItemPosition])

}