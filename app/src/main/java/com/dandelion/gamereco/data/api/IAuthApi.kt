package com.dandelion.gamereco.data.api

import com.dandelion.gamereco.data.response.VanityUrlResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IAuthApi {

    @GET("ISteamUser/ResolveVanityURL/v0001")
    suspend fun resolveVanityUrl(
        @Query("key") key: String,
        @Query("vanityurl") nickname: String
    ): VanityUrlResponse
}
