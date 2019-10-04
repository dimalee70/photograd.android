package com.example.photograd.android.home.games.domain

import com.example.photograd.android.base.BaseView
import com.example.photograd.android.home.games.data.model.GameShort

/**
 * Created by wokrey@gmail.com on 8/26/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
interface CurrentGamesView: BaseView {

    fun showCurrentGames(games: List<GameShort>)
}