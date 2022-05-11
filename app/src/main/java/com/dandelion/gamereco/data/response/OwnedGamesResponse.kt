package com.dandelion.gamereco.data.response

import com.dandelion.gamereco.domain.models.OwnedGamesModel
import com.google.gson.annotations.SerializedName

data class OwnedGamesResponse(
    @SerializedName("response") val response: GamesResponse
)

data class GamesResponse(
    @SerializedName("game_count") val gameCount: Int,
    @SerializedName("games") val games: List<Game>
)

data class Game(
    @SerializedName("appid") val appId: Int,
    @SerializedName("playtime_forever") val playtimeForever: Int,
    @SerializedName("playtime_windows_forever") val playtimeWindowsForever: Int,
    @SerializedName("playtime_mac_forever") val playtimeMacForever: Int,
    @SerializedName("playtime_linux_forever") val playtimeLinuxForever: Int
)

fun OwnedGamesResponse.toDomain() = OwnedGamesModel(games = response.games)
