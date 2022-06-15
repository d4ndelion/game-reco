package com.dandelion.gamereco.fragments.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import com.dandelion.gamereco.databinding.ItemGameMainPageBinding
import com.dandelion.gamereco.fragments.base.recycler.BaseAdapter
import com.dandelion.gamereco.fragments.base.recycler.ItemViewModel
import com.dandelion.gamereco.fragments.base.recycler.ViewHolder

class GameItemVM(title: String, imageUrl: String, val playTime: Long = 0L) : ItemViewModel() {
    val gameImageUrl = MutableLiveData(imageUrl)
    val gameTitle = MutableLiveData(title)
}

private fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<GameItemVM> {
    val layoutInflater = LayoutInflater.from(parent.context)
    val binding = ItemGameMainPageBinding.inflate(layoutInflater, parent, false)
    return ViewHolder(binding)
}

class GamesAdapter : BaseAdapter<GameItemVM>(::onCreateViewHolder)
