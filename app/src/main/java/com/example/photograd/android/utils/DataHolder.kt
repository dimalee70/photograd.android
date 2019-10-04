package com.example.photograd.android.utils

import com.example.photograd.android.auth.models.User

/**
 * Created by wokrey@gmail.com on 8/26/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
object DataHolder {
    var user: User? = null
    var sessionid: String? = null
    var hasCurrentGame: Boolean = true
    var hasPurchases: Boolean = false
}