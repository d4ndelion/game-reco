package com.dandelion.gamereco.data.response

import com.dandelion.gamereco.domain.models.RecentlyPlayedGameModel
import com.google.gson.annotations.SerializedName

data class RecentGamesResponse(
    @SerializedName("response") val response: Response
)

data class Response(
    @SerializedName("total_count") val totalCount: Int,
    @SerializedName("games") val games: List<Games>
)

data class Games(
    @SerializedName("appid") val appId: Int,
    @SerializedName("name") val name: String,
    @SerializedName("playtime_2weeks") val playtimeTwoWeeks: Int,
    @SerializedName("playtime_forever") val playtimeForever: Int,
    @SerializedName("img_icon_url") val imageIconUrl: String,
    @SerializedName("playtime_windows_forever") val playtimeWindowsForever: Int,
    @SerializedName("playtime_mac_forever") val playtimeMacForever: Int,
    @SerializedName("playtime_linux_forever") val playtimeLinuxForever: Int
)

fun RecentGamesResponse.toDomain() = response.games.map {
    RecentlyPlayedGameModel(it.appId, it.name)
}
