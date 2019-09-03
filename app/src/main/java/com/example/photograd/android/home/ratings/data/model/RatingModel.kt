package com.example.photograd.android.home.ratings.data.model

import com.example.photograd.android.auth.models.Image

/**
 * Created by wokrey@gmail.com on 9/3/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */

data class RatingData(
    val rating: List<RatedUser>
)

data class RatedUser(
    val id: Int,
    val avatar: Image,
    val username: String,
    val rating: Int,
    var rank: Int
)