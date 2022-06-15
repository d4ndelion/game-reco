package com.dandelion.gamereco.fragments.popular_games

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.dandelion.gamereco.R
import com.dandelion.gamereco.databinding.FragmentPopularGamesBinding
import com.dandelion.gamereco.fragments.base.BaseFragment
import com.dandelion.gamereco.fragments.main.GameItemVM
import com.dandelion.gamereco.fragments.main.GamesAdapter
import com.dandelion.gamereco.utils.observe
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class PopularGamesFragment : BaseFragment<PopularGamesVM, FragmentPopularGamesBinding>(R.layout.fragment_popular_games) {

    override val viewModel by viewModels<PopularGamesVM>()
    private val args by navArgs<PopularGamesFragmentArgs>()
    private val friendIDs by lazy { args.friendIDs }
    private var gamesList = mutableListOf<GameItemVM>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            vm = viewModel
            viewModel.getPopularGames(friendIDs)
            observe(viewModel.recentlyPlayedGames) {
                it.forEach(gamesList::add)
                gamesRecyclerView.adapter = GamesAdapter().apply {
                    addItems(
                        gamesList
                            .distinctBy { game -> game.gameTitle.value }
                            .sortedByDescending { game -> game.playTime }
                    )
                }
            }
        }
    }
}
