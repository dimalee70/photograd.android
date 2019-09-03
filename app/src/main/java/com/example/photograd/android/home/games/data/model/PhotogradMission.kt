package com.example.photograd.android.home.games.data.model

/**
 * Created by wokrey@gmail.com on 8/28/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
data class PhotogradMission(
    var id: Int,
    var game_amount: Int?,
    var hashkey: String?,
    var reward: Int?,
    var threshold: Int?,
    var isUpdated: Boolean = false,
    var played: Int?,
    var wins: Int
) : BaseMission()