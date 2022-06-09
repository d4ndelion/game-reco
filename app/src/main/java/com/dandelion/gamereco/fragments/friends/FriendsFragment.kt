package com.dandelion.gamereco.fragments.friends

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.dandelion.gamereco.R
import com.dandelion.gamereco.databinding.FragmentFriendsBinding
import com.dandelion.gamereco.fragments.base.BaseFragment
import com.dandelion.gamereco.utils.observe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FriendsFragment : BaseFragment<FriendsVM, FragmentFriendsBinding>(R.layout.fragment_friends) {

    override val viewModel by viewModels<FriendsVM>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            vm = viewModel
            viewModel.getFriends()
            observe(viewModel.friends) {
                friendsRecyclerView.adapter = FriendsAdapter().apply {
                    setItems(it)
                }
            }
        }
    }
}
