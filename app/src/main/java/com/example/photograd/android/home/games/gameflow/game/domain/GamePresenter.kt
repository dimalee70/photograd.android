package com.example.photograd.android.home.games.gameflow.game.domain

import com.example.photograd.android.home.games.data.model.Game
import moxy.InjectViewState
import photograd.kz.photograd.presentation.presenter.BasePresenter

/**
 * Created by wokrey@gmail.com on 8/21/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
@InjectViewState
class GamePresenter: BasePresenter<GameView>() {
    val rounds = listOf<Game>(Game(), Game(), Game())
    val userAnswers = listOf<Game>(Game(), Game(), Game(),Game(), Game(), Game(),Game(), Game(), Game())
    val opponentAnswers = listOf<Game>(Game(), Game(), Game(),Game(), Game(), Game(),Game(), Game(), Game())
}