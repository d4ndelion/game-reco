package com.dandelion.gamereco.domain.models

data class RecentlyPlayedGameModel(
    val appId: Int,
    val name: String,
    val playTime: Long
)
