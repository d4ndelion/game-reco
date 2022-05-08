package com.dandelion.gamereco.fragments.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dandelion.gamereco.domain.repositories.interfaces.IPlayerRepository
import com.dandelion.gamereco.domain.repositories.interfaces.IPreferencesRepository
import com.dandelion.gamereco.fragments.base.BaseViewModel
import com.dandelion.gamereco.utils.navigation.SCREENS.LOGIN
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber

@HiltViewModel
class MainVM @Inject constructor(
    private val prefs: IPreferencesRepository,
    private val playerRepository: IPlayerRepository
) : BaseViewModel() {

    val userName = MutableLiveData<String>()
    val userSteamId = MutableLiveData<String>()
    val userAvatar = MutableLiveData<String>()
    val userAccountLastLogDate = MutableLiveData<String>()
    val userAccountCreateDate = MutableLiveData<String>()

    fun logout() {
        viewModelScope.launch {
            prefs.clear()
            prefs.isLoggedUser = false
            navigateToScreen(LOGIN)
        }
    }

    fun getUserInfo() {
        if (prefs.steamId == null) {
            logout()
            return
        }
        viewModelScope.launch {
            playerRepository.getPlayerSummaries(prefs.steamId!!)
                .catch {
                    Timber.e(it)
                }
                .collect {
                    userAvatar.postValue(it.avatarUrl)
                    userName.postValue(it.nickname)
                    userSteamId.postValue(it.steamId)
                    userAccountLastLogDate.postValue(it.lastLogoffDate)
                    userAccountCreateDate.postValue(it.createAccountDate)
                }
        }
    }
}
