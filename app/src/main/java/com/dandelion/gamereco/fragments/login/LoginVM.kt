package com.dandelion.gamereco.fragments.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dandelion.gamereco.domain.models.VanityModel
import com.dandelion.gamereco.domain.repositories.interfaces.ISteamAuthRepository
import com.dandelion.gamereco.fragments.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@HiltViewModel
class LoginVM @Inject constructor(private val steamAuthRepository: ISteamAuthRepository) : BaseViewModel() {

    val vanityUrl = MutableLiveData<VanityModel>()

    fun logIn(nickname: String) = viewModelScope.launch {
        steamAuthRepository.getVanity(nickname)
            .catch {
                Log.e("LoginVM", "Request error", it)
            }
            .collect {
                vanityUrl.postValue(it)
            }
    }
}
