package com.example.photograd.android.home.games.data.model

import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
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
    var hashkey: String? = "test",
    var reward: Int?,
    var threshold: Int?,
    var isUpdated: Boolean,
    var played: Int?,
    var wins: Int
) : BaseMission(){

    var percentage: Float? = null
        @Bindable get() = (((threshold!! * 100) / game_amount!!).toFloat() / 100)
        set(value){
            field = value
            notifyPropertyChanged(BR.percentage)
        }

    var _reward: Int?
        @Bindable get() = reward
        set(value){
            reward = value
            notifyPropertyChanged(BR._reward)
        }

    var _played: Int?
        @Bindable get() = played
        set(value) {
            played = value
            notifyPropertyChanged(BR._played)
        }

    var _wins: Int
        @Bindable get() = wins
        set(value) {
            wins = value
            notifyPropertyChanged(BR._wins)
        }

    var _game_amount: Int?
        @Bindable get() = game_amount
        set(value){
            game_amount = value
            notifyPropertyChanged(BR._game_amount)
        }

    var _hashkey: String?
        @Bindable get() = hashkey
        set(value) {
            hashkey = value
            notifyPropertyChanged(BR._hashkey)
        }

    var _threshold: Int?
        @Bindable get() = threshold
        set(value){
            threshold = value
            notifyPropertyChanged(BR._threshold)
        }
}

data class MissionAttempt(
    val id: Int,
    val mission_id: Int,
    val game_results: List<Result>
)

data class Result(
    val game_id: Int,
    val result: GameResult,
    val order_number: Int
)