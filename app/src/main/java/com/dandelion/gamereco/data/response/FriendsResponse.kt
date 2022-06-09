package com.dandelion.gamereco.data.response

import com.google.gson.annotations.SerializedName

data class FriendsResponse(
    @SerializedName("friendslist") val friendsList: FriendsList
)

data class FriendsList(
    @SerializedName("friends") val friends: List<Friends>
)

data class Friends(
    @SerializedName("steamid") val steamId: String,
    @SerializedName("relationship") val relationship: String,
    @SerializedName("friend_since") val friendSince: Int
)
