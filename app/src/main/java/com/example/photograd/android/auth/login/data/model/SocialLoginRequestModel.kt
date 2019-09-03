package com.example.photograd.android.auth.login.data.model

import com.example.photograd.android.utils.Constants

/**
 * Created by wokrey@gmail.com on 8/26/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
class SocialLoginRequestModel(
    val auth_token: String,
    val social_network: String,
    val onesignal_player_id: String,
    val platform: Int,
    val api_version: String = Constants.API_VERSION
)