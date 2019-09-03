package com.example.photograd.android.auth.login.data.model

import com.example.photograd.android.auth.models.User
import com.example.photograd.android.base.models.InGameNotification

/**
 * Created by wokrey@gmail.com on 8/19/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */

data class LoginData(
    val auth: Auth,
    val notifications: List<InGameNotification>,
    val user: User
)

data class Auth(
    val sessionid: String
)