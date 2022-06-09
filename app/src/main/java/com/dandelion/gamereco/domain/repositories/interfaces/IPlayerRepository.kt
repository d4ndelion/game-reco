package com.dandelion.gamereco.domain.repositories.interfaces

import com.dandelion.gamereco.domain.models.GameStatsModel
import com.dandelion.gamereco.domain.models.OwnedGamesModel
import com.dandelion.gamereco.domain.models.PlayerModel
import com.dandelion.gamereco.domain.models.RecentlyPlayedGameModel
import kotlinx.coroutines.flow.Flow

interface IPlayerRepository {
    suspend fun getPlayerSummaries(): Flow<PlayerModel>
    suspend fun getPlayersSummaries(ids: List<String>): Flow<List<PlayerModel>>
    suspend fun getOwnedGames(): Flow<OwnedGamesModel>
    suspend fun getGameInfo(appId: Int): Flow<GameStatsModel>
    suspend fun getRecentlyPlayed(): Flow<List<RecentlyPlayedGameModel>>
    suspend fun getFriendsList(): Flow<List<String>>
}
