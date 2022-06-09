package com.dandelion.gamereco.fragments.friends

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dandelion.gamereco.domain.repositories.interfaces.IPlayerRepository
import com.dandelion.gamereco.fragments.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import timber.log.Timber

@HiltViewModel
class FriendsVM @Inject constructor(private val playerRepository: IPlayerRepository) : BaseViewModel() {

    val friends = MutableLiveData<List<FriendItemVM>>()
    val isDataLoadingEnded = MutableLiveData(false)

    fun getFriends() = viewModelScope.launch {
        playerRepository.getFriendsList()
            .catch {
                Timber.e(it)
            }
            .collect {
                getFriendsInformation(it)
            }
    }

    private fun getFriendsInformation(ids: List<String>) = viewModelScope.launch {
        playerRepository.getPlayersSummaries(ids)
            .catch {
                Timber.e(it)
            }
            .map {
                it.map { friend -> FriendItemVM(friend.avatarUrl, friend.nickname) }
            }
            .collect {
                friends.postValue(it)
                isDataLoadingEnded.postValue(true)
            }
    }
}
