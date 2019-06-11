package com.raqun.core.presentation.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.raqun.core.preconditions.AndroidPreconditions
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class RecyclerViewAdapter constructor(
    val items: MutableList<DisplayItem> = ArrayList(),
    private val selectedItems: MutableList<DisplayItem> = ArrayList(),
    private val itemComperator: DisplayItemComperator,
    private val viewHolderFactoryMap: Map<Int, ViewHolderFactory>,
    private val viewBinderFactoryMap: Map<Int, ViewHolderBinder>,
    private val androidPreconditions: AndroidPreconditions
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), DiffAdapter, SelectionAdapter, CoroutineScope {

    var itemClickListener: ((item: DisplayItem) -> Unit)? = null
    var itemLongClickListener: ((item: DisplayItem) -> Boolean)? = null

    override var coroutineContext: CoroutineContext = Dispatchers.Main

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        viewHolderFactoryMap[viewType]?.createViewHolder(parent)!!

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        viewBinderFactoryMap[items[position].type()]?.bind(holder, items[position])
        (holder as ViewHolder).itemClickListener = itemClickListener
        holder.itemLongClickListener = itemLongClickListener
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = items[position].type()

    override fun update(newItems: List<DisplayItem>) {
        androidPreconditions.assertUiThread()
        if (items.isEmpty()) {
            updateAllItems(newItems)
        } else {
            updateDiffItemsOnly(newItems)
        }
    }

    override fun updateAllItems(newItems: List<DisplayItem>) {
        updateItems(newItems)
        notifyDataSetChanged()
    }

    override fun updateDiffItemsOnly(newItems: List<DisplayItem>) {
        launch {
            val diffResult = calculateDiffResult(newItems).await()
            updateItems(newItems)
            updateWithOnlyDiffResult(diffResult)
        }
    }

    override fun updateItems(newItems: List<DisplayItem>) {
        items.run {
            clear()
            addAll(newItems)
        }
    }

    override fun calculateDiff(newItems: List<DisplayItem>): DiffUtil.DiffResult =
        DiffUtil.calculateDiff(
            DiffUtilImpl(
                items,
                newItems,
                itemComperator
            )
        )

    override fun updateWithOnlyDiffResult(result: DiffUtil.DiffResult) {
        result.dispatchUpdatesTo(this)
    }

    override fun select(pos: Int) {
        val item = items[pos]
        if (selectedItems.contains(item)) {
            selectedItems.remove(item)
            if (item is SelectableItem) {
                item.isSelected = false
            }
        } else {
            selectedItems.add(item)
            if (item is SelectableItem) {
                item.isSelected = true
            }
        }
        notifyItemChanged(pos)
    }

    override fun clear() {
        for (item in items) {
            if (item is SelectableItem) {
                item.isSelected = false
            }
        }
        selectedItems.clear()
        notifyDataSetChanged()
    }

    override fun getSelectedItemCount(): Int = selectedItems.size

    override fun getSelectedItems(): List<DisplayItem> = selectedItems

    private fun calculateDiffResult(newItems: List<DisplayItem>): Deferred<DiffUtil.DiffResult> = GlobalScope.async {
        calculateDiff(newItems)
    }
}