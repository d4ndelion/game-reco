package com.dandelion.gamereco.data.response

import com.dandelion.gamereco.domain.models.VanityModel
import com.google.gson.annotations.SerializedName

data class VanityUrlResponse(
    @SerializedName("response") var response: SteamResponse
)

data class SteamResponse(
    @SerializedName("steamid") var steamid: String,
    @SerializedName("success") var success: Int
)

fun VanityUrlResponse.toVanityModel() = VanityModel(response.steamid)
