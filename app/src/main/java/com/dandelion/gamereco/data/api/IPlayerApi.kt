package com.dandelion.gamereco.data.api

import com.dandelion.gamereco.data.response.FriendsResponse
import com.dandelion.gamereco.data.response.GameStatsResponse
import com.dandelion.gamereco.data.response.OwnedGamesResponse
import com.dandelion.gamereco.data.response.PlayerSummariesResponse
import com.dandelion.gamereco.data.response.RecentGamesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IPlayerApi {

    @GET("ISteamUser/GetPlayerSummaries/v2")
    suspend fun getPlayerSummaries(
        @Query("key") key: String,
        @Query("steamids") steamId: String
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

    @GET("IPlayerService/GetRecentlyPlayedGames/v0001")
    suspend fun getRecentlyPlayed(
        @Query("key") key: String,
        @Query("steamid") steamId: String,
        @Query("format") format: String
    ): RecentGamesResponse

    @GET("ISteamUser/GetFriendList/v1")
    suspend fun getFriendsList(
        @Query("key") key: String,
        @Query("steamid") steamId: String,
        @Query("relationship") relationship: String
    ): FriendsResponse
}
