package com.dandelion.gamereco.data.api

import com.dandelion.gamereco.data.response.GameStatsResponse
import com.dandelion.gamereco.data.response.OwnedGamesResponse
import com.dandelion.gamereco.data.response.PlayerSummariesResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface IPlayerApi {

    @GET("ISteamUser/GetPlayerSummaries/v2")
    suspend fun getPlayerSummaries(
        @Query("key") key: String,
        @Query("steamids") steamId: ArrayList<String>
    ): PlayerSummariesResponse

    @GET("IPlayerService/GetOwnedGames/v0001")
    suspend fun getOwnedGames(
        @Query("key") key: String,
        @Query("steamid") steamId: String,
        @Query("format") format: String
    ): OwnedGamesResponse

    @GET("ISteamUserStats/GetUserStatsForGame/v2")
    suspend fun getGameInfo(
        @Query("key") key: String,
        @Query("steamid") steamId: String,
        @Query("appid") appId: Int
    ): GameStatsResponse
}
