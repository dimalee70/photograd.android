package com.example.photograd.android.auth.login.domain

import com.example.photograd.android.base.BaseView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

/**
 * Created by wokrey@gmail.com on 8/26/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
@StateStrategyType(OneExecutionStateStrategy::class)
interface LoginView: BaseView {
    fun showHome()
    fun showRegistration()

    fun onLoginClicked()
}