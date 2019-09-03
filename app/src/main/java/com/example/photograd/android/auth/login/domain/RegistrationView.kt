package com.example.photograd.android.auth.login.domain

import com.example.photograd.android.base.BaseView

/**
 * Created by wokrey@gmail.com on 8/26/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
interface RegistrationView: BaseView {

    fun registerClicked()
    fun showHome()
    fun continueClicked()
}