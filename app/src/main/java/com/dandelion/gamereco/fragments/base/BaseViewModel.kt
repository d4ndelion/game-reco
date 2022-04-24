package com.dandelion.gamereco.fragments.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dandelion.gamereco.utils.navigation.SCREENS
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    private val screenChannel = Channel<SCREENS>(Channel.BUFFERED)
    val screenFlow = screenChannel.receiveAsFlow()

    fun navigateToScreen(screen: SCREENS) {
        viewModelScope.launch(Dispatchers.Main) {
            screenChannel.send(screen)
        }
    }
}
