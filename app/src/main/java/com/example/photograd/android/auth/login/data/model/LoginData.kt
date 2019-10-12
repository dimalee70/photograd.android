package com.example.photograd.android.auth.login.data.model

import com.example.photograd.android.auth.models.User
import com.example.photograd.android.base.models.InGameNotification
import com.example.photograd.android.home.data.model.OfferCategory

/**
 * Created by wokrey@gmail.com on 8/19/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */

data class LoginData(
    val session_id: String,
    val notifications: List<InGameNotification>,
    val user: User,
    val current_games_amount: Int,
    val purchases_amount: Int,
    val settings: UserPreferences,
    val offer_categories: List<OfferCategory>
)

data class UserPreferences(
    val chat_mode: Int,
    val dynamic_background: Boolean,
    val sound_on: Boolean
)