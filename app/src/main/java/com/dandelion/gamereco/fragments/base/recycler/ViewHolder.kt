package com.dandelion.gamereco.fragments.base.recycler

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.dandelion.gamereco.BR

class ViewHolder<T : ItemViewModel>(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(position: Int, viewModel: T) {
        binding.setVariable(BR.vm, viewModel)
    }
}
