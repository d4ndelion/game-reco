package com.dandelion.gamereco.utils.navigation

import androidx.annotation.IdRes
import androidx.navigation.NavController
import com.dandelion.gamereco.R

fun NavController.setCurrentScreenWithNavController(screen: SCREENS) {
    if (screen.navDirections == null) {
        runCatching { navigate(screen.screenId) }
    } else {
        runCatching {
            navigate(screen.navDirections!!)
            screen.navDirections = null
        }
    }
    if (screen.getStartDestinationScreens()) {
        setStartDestination(screen.screenId)
    }
}

private fun SCREENS.getStartDestinationScreens(): Boolean {
    return this == SCREENS.LOGIN || this == SCREENS.MAIN
}

fun NavController.setStartDestination(@IdRes destinationId: Int) {
    val newGraph = navInflater.inflate(R.navigation.navigation).apply {
        if (startDestinationId == destinationId) {
            return
        }
        setStartDestination(destinationId)
    }
    graph = newGraph
}