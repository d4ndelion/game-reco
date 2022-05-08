package com.dandelion.gamereco.data.api

import com.dandelion.gamereco.data.response.PlayerSummariesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IPlayerApi {

    @GET("ISteamUser/GetPlayerSummaries/v2")
    suspend fun getPlayerSummaries(
        @Query("key") key: String,
        @Query("steamids") steamId: ArrayList<String>
    ): PlayerSummariesResponse
}
