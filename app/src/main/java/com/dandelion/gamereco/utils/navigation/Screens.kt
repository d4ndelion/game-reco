package com.dandelion.gamereco.utils.navigation

import androidx.navigation.NavDirections
import com.dandelion.gamereco.R

enum class SCREENS(
    val screenId: Int,
    var navDirections: NavDirections? = null,
    var isToolbarVisible: Boolean = true
) {
    SPLASH(R.id.splashFragment, isToolbarVisible = false),
    LOGIN(R.id.loginFragment),
    MAIN(R.id.mainFragment),
    FRIENDS(R.id.friendsFragment),
    POPULAR_GAMES(R.id.popularGamesFragment);
}
