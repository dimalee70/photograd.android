package com.example.photograd.android.auth.login.data.model

import com.example.photograd.android.utils.Constants

/**
 * Created by wokrey@gmail.com on 8/26/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
data class LoginRequestModel(
    val identificator: String,
    val password: String,
    val platform: Int = Constants.ANDROID_PLATFORM,
    val api_version: String = Constants.API_VERSION,
    var onesignal_player_id: String
)