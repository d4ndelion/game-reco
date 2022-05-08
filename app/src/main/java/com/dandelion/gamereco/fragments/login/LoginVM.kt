package com.dandelion.gamereco.fragments.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dandelion.gamereco.domain.repositories.interfaces.IPreferencesRepository
import com.dandelion.gamereco.domain.repositories.interfaces.ISteamAuthRepository
import com.dandelion.gamereco.fragments.base.BaseViewModel
import com.dandelion.gamereco.utils.errors.ERRORS.LOG_IN
import com.dandelion.gamereco.utils.navigation.SCREENS.MAIN
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

private const val NO_MATCH = "No match"

@HiltViewModel
class LoginVM @Inject constructor(private val steamAuthRepository: ISteamAuthRepository, private val prefs: IPreferencesRepository) :
    BaseViewModel() {

    val nickname = MutableLiveData<String>()

    fun logIn() = viewModelScope.launch {
        steamAuthRepository.getVanity(nickname.value ?: "")
            .catch {
                error.sendError(LOG_IN)
            }
            .collect {
                if (it.message == NO_MATCH) {
                    error.sendError(LOG_IN)
                    return@collect
                }
                prefs.apply {
                    isLoggedUser = true
                    steamId = it.vanityString
                }
                navigateToScreen(MAIN)
            }
    }
}
