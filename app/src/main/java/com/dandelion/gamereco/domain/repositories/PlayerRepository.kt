package com.dandelion.gamereco.domain.repositories

import com.dandelion.gamereco.data.api.IPlayerApi
import com.dandelion.gamereco.data.response.toDomain
import com.dandelion.gamereco.domain.models.PlayerModel
import com.dandelion.gamereco.domain.repositories.interfaces.IPlayerRepository
import com.dandelion.gamereco.utils.STEAM_API_KEY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PlayerRepository(private val playerApi: IPlayerApi) : IPlayerRepository {

    override suspend fun getPlayerSummaries(steamId: String): Flow<PlayerModel> = flow {
        val playerSummaries = playerApi.getPlayerSummaries(STEAM_API_KEY, arrayListOf(steamId)).toDomain()
        emit(playerSummaries)
    }
}
