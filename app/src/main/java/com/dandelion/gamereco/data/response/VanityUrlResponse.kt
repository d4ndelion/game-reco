package com.dandelion.gamereco.data.response

import com.dandelion.gamereco.domain.models.VanityModel
import com.google.gson.annotations.SerializedName

data class VanityUrlResponse(
    @SerializedName("response") val response: SteamResponse
)

data class SteamResponse(
    @SerializedName("steamid") val steamId: String,
    @SerializedName("success") val success: Int,
    @SerializedName("message") val message: String?
)

fun VanityUrlResponse.toVanityModel() = VanityModel(response.steamId, response.message)
