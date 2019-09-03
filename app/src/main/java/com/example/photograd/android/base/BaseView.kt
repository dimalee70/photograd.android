package com.example.photograd.android.base

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType


@StateStrategyType(OneExecutionStateStrategy::class)
interface BaseView : MvpView {
    @StateStrategyType(SkipStrategy::class)
    fun showError(exception: Throwable)

    @StateStrategyType(SkipStrategy::class)
    fun showError(message: String, codeError: Int)
    @StateStrategyType(SkipStrategy::class)
    fun hideProgress()

    @StateStrategyType(SkipStrategy::class)
    fun showProgress()

    fun dismissDialogs()

    fun showRequestSuccessfully(message: String)

}