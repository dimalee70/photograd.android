package com.example.photograd.android.home.games.data.model

import com.google.gson.annotations.SerializedName

data class FriendsModel(
    val overall: Int,
    val friends: List<UserShort>,
    val requests: List<UserShort>
)

data class Friend(
    val user: UserShort,
    val score: String
)
