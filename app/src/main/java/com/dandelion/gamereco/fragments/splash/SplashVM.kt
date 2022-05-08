package com.dandelion.gamereco.fragments.splash

import android.os.CountDownTimer
import com.dandelion.gamereco.domain.repositories.interfaces.IPreferencesRepository
import com.dandelion.gamereco.fragments.base.BaseViewModel
import com.dandelion.gamereco.utils.navigation.SCREENS.LOGIN
import com.dandelion.gamereco.utils.navigation.SCREENS.MAIN
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashVM @Inject constructor(private val prefs: IPreferencesRepository) : BaseViewModel() {

    private val timer = object : CountDownTimer(2000L, 10L) {
        override fun onTick(p0: Long) { }

        override fun onFinish() {
            if (prefs.isLoggedUser) {
                navigateToScreen(MAIN)
            } else navigateToScreen(LOGIN)
        }
    }

    init {
        timer.start()
    }
}
