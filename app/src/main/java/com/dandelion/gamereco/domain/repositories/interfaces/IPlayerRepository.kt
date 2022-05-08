package com.dandelion.gamereco.domain.repositories.interfaces

import com.dandelion.gamereco.domain.models.PlayerModel
import kotlinx.coroutines.flow.Flow

interface IPlayerRepository {
    suspend fun getPlayerSummaries(steamId: String): Flow<PlayerModel>
}
