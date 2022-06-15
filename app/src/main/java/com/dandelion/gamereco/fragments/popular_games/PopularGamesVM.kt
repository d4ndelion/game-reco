package com.dandelion.gamereco.fragments.popular_games

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dandelion.gamereco.domain.models.RecentlyPlayedGameModel
import com.dandelion.gamereco.domain.repositories.interfaces.IPlayerRepository
import com.dandelion.gamereco.fragments.base.BaseViewModel
import com.dandelion.gamereco.fragments.main.GameItemVM
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import timber.log.Timber

@HiltViewModel
class PopularGamesVM @Inject constructor(private val playerRepository: IPlayerRepository) : BaseViewModel() {

    val recentlyPlayedGames = MutableLiveData<List<GameItemVM>>()
    val isDataLoadingEnded = MutableLiveData(true)

    fun getPopularGames(friendIDs: Array<String>) = viewModelScope.launch {
        friendIDs.forEach {
            viewModelScope.launch {
                playerRepository.getFriendsRecentlyPlayed(it)
                    .catch {
                        Timber.e(it)
                    }
                    .map {
                        it.map { game ->
                            GameItemVM(game.name, "https://steamcdn-a.akamaihd.net/steam/apps/${game.appId}/header.jpg", game.playTime)
                        }
                    }
                    .collect {
                        recentlyPlayedGames.postValue(it)
                    }
            }
        }
    }
}
