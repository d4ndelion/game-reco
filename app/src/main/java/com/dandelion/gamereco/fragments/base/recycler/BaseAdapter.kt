package com.dandelion.gamereco.fragments.base.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

open class BaseAdapter<T : ItemViewModel>(
    private val createViewHolderDelegate: (parent: ViewGroup, viewType: Int) -> ViewHolder<T>
) : RecyclerView.Adapter<ViewHolder<T>>() {

    private val items = mutableListOf<T>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = createViewHolderDelegate.invoke(parent, viewType)

    override fun onBindViewHolder(holder: ViewHolder<T>, position: Int) {
        holder.bind(position, items[position])
    }

    override fun getItemCount() = items.size

    fun setItems(items: List<T>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun getItems() = items

    fun getItemAt(position: Int): T? {
        if (position < 0 || position > items.size - 1) return null
        return items[position]
    }
}
