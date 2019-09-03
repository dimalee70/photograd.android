package com.example.photograd.android.base.models

import photograd.kz.photograd.models.enums.GameResult
import photograd.kz.photograd.models.enums.GameType
import photograd.kz.photograd.models.enums.NotificationType
import photograd.kz.photograd.models.enums.RewardType
import java.util.*

/**
 * Created by wokrey@gmail.com on 8/19/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
data class InGameNotificationData(
    var notification_type: NotificationType?,
    val game_id: Long?,
    val notification_id: String?,
    val username: String?,
    val game_type: GameType?,
    val rating_change: Int?,
    val game_result: GameResult?,
    val mission_partner: String?,
    val victories: String?,
    val game_score: String?,
    val avatar_url: String?,
    val victories_left: Int?,
    val achievement_id: Long?,
    val mission_id: Long?,
    val result: Int?,
    val reward_id: Long?,
    val reward_expiration_date: Date?,
    val reward_apples: Int?,
    val reward_description: String?,
    val reward_type: RewardType?,
    val place: Int?,
    val partner_mission_id: Long?,
    val target_page: String?,
    val user_id: Long?,
    val image_url: String?,
    val reject_reason: String?,
    val comment: String?,
    val question_text: String?,
    val order_number: Int?,
    val reward_amount: Int?,
    val personal_score: String?
)
{
    fun applesText(): String?
    {
        if (game_type == GameType.TYPE_DUEL)
        {
            when (game_result) {
                GameResult.RESULT_WON -> {
                    return "1"
                }
                GameResult.RESULT_LOST -> {
                    return "-1"
                }
                GameResult.RESULT_DRAW -> {
                    return "0"
                }
            }
        }
        return null
    }
}