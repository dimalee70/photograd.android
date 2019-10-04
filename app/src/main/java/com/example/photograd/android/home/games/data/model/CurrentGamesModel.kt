package com.example.photograd.android.home.games.data.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.photograd.android.utils.DataHolder
import photograd.kz.photograd.models.enums.GameStatus
import photograd.kz.photograd.models.enums.GameType

/**
 * Created by wokrey@gmail.com on 9/5/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
data class CurrentGamesData(
    val active_games: List<GameShort>?,
    val game_requests: List<GameShort>?
)

data class GameShort(
    val id: Int,
    val player1: UserShort,
    val player2: UserShort,
    val winner_id: Int?,
    val game_type: GameType,
    val score: String,
    val active_round: Int?,
    val is_player_turn: Boolean,
    val time_left: Int,
    val hashkey: String?,
    val status: GameStatus,
    val mission_reward: Int?,
    val mission_partner: String?,
    val personal_score: String?
) : BaseObservable() {

    var opponent: UserShort? = null
        @Bindable get() = if (player1.id == DataHolder.user?.id) {
            player2
        } else {
            player1
        }

}

data class UserShort(
    val id: Int,
    val username: String,
    val rating: Int,
    val avatar_url: String,
    val true_almatian: Boolean,
    val special_status: Int
)