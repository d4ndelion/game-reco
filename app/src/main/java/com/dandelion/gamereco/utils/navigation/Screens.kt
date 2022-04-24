package com.dandelion.gamereco.utils.navigation

import androidx.navigation.NavDirections
import com.dandelion.gamereco.R

enum class SCREENS(
    val screenId: Int,
    var navDirections: NavDirections? = null
) {
    LOGIN(R.id.loginFragment),
    MAIN(R.id.mainFragment)
}
