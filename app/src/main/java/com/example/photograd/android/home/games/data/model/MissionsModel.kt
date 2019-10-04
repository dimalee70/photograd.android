package com.example.photograd.android.home.games.data.model

import photograd.kz.photograd.models.enums.GameResult

/**
 * Created by wokrey@gmail.com on 8/28/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */

data class MissionsData(
    val missions: List<PhotogradMission>,
    val partner_missions: List<PartnerMission>,
    val active_mission_attempt: MissionAttempt
)
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

data class MissionAttempt(
    val id: Int,
    val mission_id: Int,
    val game_results: Result
)

data class Result(
    val game_id: Int,
    val result: GameResult,
    val order_number: Int
)