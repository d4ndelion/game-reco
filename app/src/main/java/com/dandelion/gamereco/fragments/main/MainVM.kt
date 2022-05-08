package com.dandelion.gamereco.fragments.main

import androidx.lifecycle.viewModelScope
import com.dandelion.gamereco.domain.repositories.interfaces.IPreferencesRepository
import com.dandelion.gamereco.fragments.base.BaseViewModel
import com.dandelion.gamereco.utils.navigation.SCREENS.LOGIN
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class MainVM @Inject constructor(private val prefs: IPreferencesRepository) : BaseViewModel() {

    fun logout() {
        viewModelScope.launch {
            prefs.clear()
            prefs.isLoggedUser = false
            navigateToScreen(LOGIN)
        }
    }
}
