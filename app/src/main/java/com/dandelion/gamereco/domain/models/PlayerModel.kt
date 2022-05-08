package com.dandelion.gamereco.domain.models

data class PlayerModel(
    val nickname: String,
    val steamId: String,
    val avatarUrl: String,
    val createAccountDate: String,
    val lastLogoffDate: String
)
