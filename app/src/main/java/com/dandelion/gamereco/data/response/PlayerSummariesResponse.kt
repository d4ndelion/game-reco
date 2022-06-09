package com.dandelion.gamereco.data.response

import com.dandelion.gamereco.domain.models.PlayerModel
import com.dandelion.gamereco.utils.getDateFromUnixTime
import com.google.gson.annotations.SerializedName

data class PlayerSummariesResponse(@SerializedName("response") val response: PlayersResponse)

data class PlayersResponse(@SerializedName("players") var players: ArrayList<Players>)

data class Players(
    @SerializedName("steamid") val steamId: String,
    @SerializedName("communityvisibilitystate") val communityVisibilityState: Int,
    @SerializedName("profilestate") val profileState: Int,
    @SerializedName("personaname") val personaName: String,
    @SerializedName("profileurl") val profileUrl: String,
    @SerializedName("avatar") val avatar: String,
    @SerializedName("avatarmedium") val avatarMedium: String,
    @SerializedName("avatarfull") val avatarFull: String,
    @SerializedName("avatarhash") val avatarHash: String,
    @SerializedName("lastlogoff") val lastLogoff: Long,
    @SerializedName("personastate") val personaState: Int,
    @SerializedName("realname") val realName: String,
    @SerializedName("primaryclanid") val primaryClanId: String,
    @SerializedName("timecreated") val timeCreated: Long,
    @SerializedName("personastateflags") val personaStateFlags: Int,
    @SerializedName("loccountrycode") val locCountryCode: String,
    @SerializedName("locstatecode") val locStateCode: String,
    @SerializedName("loccityid") val locCityId: Int
)

fun PlayerSummariesResponse.toDomain() = PlayerModel(
    nickname = response.players[0].personaName,
    steamId = response.players[0].steamId,
    avatarUrl = response.players[0].avatarFull,
    createAccountDate = getDateFromUnixTime(response.players[0].timeCreated) ?: "",
    lastLogoffDate = getDateFromUnixTime(response.players[0].lastLogoff) ?: ""
)

fun PlayerSummariesResponse.toFriendsList() = response.players.map {
    PlayerModel(
        nickname = it.personaName,
        steamId = it.steamId,
        avatarUrl = it.avatarFull,
        createAccountDate = getDateFromUnixTime(it.timeCreated) ?: "",
        lastLogoffDate = getDateFromUnixTime(it.lastLogoff) ?: ""
    )
}
