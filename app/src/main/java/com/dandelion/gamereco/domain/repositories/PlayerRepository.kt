package com.dandelion.gamereco.domain.repositories

import com.dandelion.gamereco.data.api.IPlayerApi
import com.dandelion.gamereco.data.response.Friends
import com.dandelion.gamereco.data.response.toDomain
import com.dandelion.gamereco.data.response.toFriendsList
import com.dandelion.gamereco.domain.models.GameStatsModel
import com.dandelion.gamereco.domain.models.OwnedGamesModel
import com.dandelion.gamereco.domain.models.PlayerModel
import com.dandelion.gamereco.domain.models.RecentlyPlayedGameModel
import com.dandelion.gamereco.domain.repositories.interfaces.IPlayerRepository
import com.dandelion.gamereco.domain.repositories.interfaces.IPreferencesRepository
import com.dandelion.gamereco.utils.STEAM_API_KEY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.internal.notifyAll

private const val JSON_FORMAT = "json"
private const val RELATION_FRIEND = "friend"
private const val COMMA = ","

class PlayerRepository(private val playerApi: IPlayerApi, private val prefs: IPreferencesRepository) : IPlayerRepository {

    override suspend fun getPlayerSummaries(): Flow<PlayerModel> = flow {
        val playerSummaries = playerApi.getPlayerSummaries(STEAM_API_KEY, prefs.steamId ?: "").toDomain()
        emit(playerSummaries)
    }

    override suspend fun getPlayersSummaries(ids: List<String>): Flow<List<PlayerModel>> = flow {
        val playersSummaries =
            playerApi.getPlayerSummaries(STEAM_API_KEY, ids.joinToString(COMMA)).toFriendsList().filter { // filter bad nicknames
                !(it.nickname == "Cook old" || it.nickname == "ангел-предохранитель" || it.nickname == "я не жирная"
                        || it.nickname == "я не жирная" || it.nickname == "micropenis" || it.nickname == "д0гg(ТОЧКА)и \$тайл ;)"
                        || it.nickname == "Члены? Пробовал!" || it.nickname == "Спецнас Гондурас" || it.nickname == "HH.Злой_Путин"
                        || it.nickname == "Батин ремень" || it.nickname == "Влад Мужские Фекалии" || it.nickname == "НЫАААААА"
                        || it.nickname == "Няша<3" || it.nickname == "надоела дота(" || it.nickname == "PLATI NALOG"
                        || it.nickname == "tak she tyashko kak tansh" || it.nickname == "Zlou__DED" || it.nickname == "Елена Темникова"
                        || it.nickname == "road to 0k" || it.nickname == "кристинк@\"+\"" || it.nickname == "тима не в курсе")
            }
        emit(playersSummaries)
    }

    override suspend fun getOwnedGames(): Flow<OwnedGamesModel> = flow {
        val ownedGames = playerApi.getOwnedGames(STEAM_API_KEY, prefs.steamId ?: "", JSON_FORMAT).toDomain()
        emit(ownedGames)
    }

    override suspend fun getGameInfo(appId: Int): Flow<GameStatsModel> = flow {
        val gameInfo = playerApi.getGameInfo(STEAM_API_KEY, prefs.steamId ?: "", appId).toDomain()
        emit(gameInfo)
    }

    override suspend fun getRecentlyPlayed(): Flow<List<RecentlyPlayedGameModel>> = flow {
        val recentlyPlayedGames = playerApi.getRecentlyPlayed(STEAM_API_KEY, prefs.steamId ?: "", JSON_FORMAT).toDomain()
        emit(recentlyPlayedGames)
    }

    override suspend fun getFriendsList(): Flow<List<String>> = flow {
        val friendsListResponse = playerApi.getFriendsList(STEAM_API_KEY, prefs.steamId ?: "", RELATION_FRIEND)
            .friendsList.friends.map(Friends::steamId)
        emit(friendsListResponse)
    }
}
