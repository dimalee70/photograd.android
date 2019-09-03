package com.example.photograd.android.auth.models

import com.example.photograd.android.utils.Constants

/**
 * Created by wokrey@gmail.com on 8/19/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
data class AuthParams(
    val sessionid: String,
    val onesignal_player_id: String,
    val platform: Int,
    val api_version: String = Constants.API_VERSION
)