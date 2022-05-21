package com.dandelion.gamereco.fragments.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.dandelion.gamereco.R
import com.dandelion.gamereco.databinding.FragmentMainBinding
import com.dandelion.gamereco.fragments.base.BaseFragment
import com.dandelion.gamereco.utils.observe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<MainVM, FragmentMainBinding>(R.layout.fragment_main) {

    override val viewModel by viewModels<MainVM>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            vm = viewModel
            viewModel.getUserInfo()
            viewModel.getRecentGames()
            observe(viewModel.recentGames) {
                gamesRecyclerView.adapter = GamesAdapter().apply {
                    setItems(it)
                }
            }
        }
    }
}
