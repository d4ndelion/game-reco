package com.dandelion.gamereco.domain.repositories

import com.dandelion.gamereco.data.api.IPlayerApi
import com.dandelion.gamereco.data.response.toDomain
import com.dandelion.gamereco.domain.models.GameStatsModel
import com.dandelion.gamereco.domain.models.OwnedGamesModel
import com.dandelion.gamereco.domain.models.PlayerModel
import com.dandelion.gamereco.domain.repositories.interfaces.IPlayerRepository
import com.dandelion.gamereco.domain.repositories.interfaces.IPreferencesRepository
import com.dandelion.gamereco.utils.STEAM_API_KEY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

private const val JSON_FORMAT = "json"

class PlayerRepository(private val playerApi: IPlayerApi, private val prefs: IPreferencesRepository) : IPlayerRepository {

    override suspend fun getPlayerSummaries(): Flow<PlayerModel> = flow {
        val playerSummaries = playerApi.getPlayerSummaries(STEAM_API_KEY, arrayListOf(prefs.steamId ?: "")).toDomain()
        emit(playerSummaries)
    }

    override suspend fun getOwnedGames(): Flow<OwnedGamesModel> = flow {
        val ownedGames = playerApi.getOwnedGames(STEAM_API_KEY, prefs.steamId ?: "", JSON_FORMAT).toDomain()
        emit(ownedGames)
    }

    override suspend fun getGameInfo(appId: Int): Flow<GameStatsModel> = flow {
        val gameInfo = playerApi.getGameInfo(STEAM_API_KEY, prefs.steamId ?: "", appId).toDomain()
        emit(gameInfo)
    }
}
