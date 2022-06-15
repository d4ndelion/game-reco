package com.dandelion.gamereco.fragments.base.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

open class BaseAdapter<T : ItemViewModel>(
    private val createViewHolderDelegate: (parent: ViewGroup, viewType: Int) -> ViewHolder<T>
) : RecyclerView.Adapter<ViewHolder<T>>() {

    val data = mutableListOf<T>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = createViewHolderDelegate.invoke(parent, viewType)

    override fun onBindViewHolder(holder: ViewHolder<T>, position: Int) {
        holder.bind(position, data[position])
    }

    override fun getItemCount() = data.size

    fun setItems(items: List<T>) {
        this.data.clear()
        this.data.addAll(items)
        notifyDataSetChanged()
    }

    fun addItems(items: List<T>) {
        this.data.addAll(items)
    }

    fun getItems() = data

    fun getItemAt(position: Int): T? {
        if (position < 0 || position > data.size - 1) return null
        return data[position]
    }
}
