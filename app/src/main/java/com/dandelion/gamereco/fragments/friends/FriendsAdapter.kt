package com.dandelion.gamereco.fragments.friends

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import com.dandelion.gamereco.databinding.ItemFriendBinding
import com.dandelion.gamereco.databinding.ItemGameMainPageBinding
import com.dandelion.gamereco.fragments.base.recycler.BaseAdapter
import com.dandelion.gamereco.fragments.base.recycler.ItemViewModel
import com.dandelion.gamereco.fragments.base.recycler.ViewHolder

class FriendItemVM(avatarUrl: String, nickname: String) : ItemViewModel() {
    val avatarUrl = MutableLiveData(avatarUrl)
    val nickname = MutableLiveData(nickname)
}

private fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<FriendItemVM> {
    val layoutInflater = LayoutInflater.from(parent.context)
    val binding = ItemFriendBinding.inflate(layoutInflater, parent, false)
    return ViewHolder(binding)
}

class FriendsAdapter : BaseAdapter<FriendItemVM>(::onCreateViewHolder)
