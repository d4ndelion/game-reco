package com.dandelion.gamereco.domain.models

import com.dandelion.gamereco.data.response.Achievements
import com.dandelion.gamereco.data.response.GameStatsResponse
import com.dandelion.gamereco.data.response.Stats

data class GameStatsModel(
    val gameName: String,
    val stats: List<Stats>,
    val achievements: List<Achievements>
)

fun GameStatsResponse.toDomain() = GameStatsModel(
    playerStats.gameName,
    playerStats.stats,
    playerStats.achievements
)
