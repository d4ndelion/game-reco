package com.dandelion.gamereco.data.response

import com.google.gson.annotations.SerializedName

data class GameStatsResponse(
    @SerializedName("playerstats") val playerStats: PlayerStats
)

data class PlayerStats(
    @SerializedName("steamID") val steamID: Int,
    @SerializedName("gameName") val gameName: String,
    @SerializedName("stats") val stats: List<Stats>,
    @SerializedName("achievements") val achievements: List<Achievements>
)

data class Achievements(
    @SerializedName("name") val name: String,
    @SerializedName("achieved") val achieved: Int
)

data class Stats(
    @SerializedName("name") val name: String,
    @SerializedName("value") val value: Int
)
