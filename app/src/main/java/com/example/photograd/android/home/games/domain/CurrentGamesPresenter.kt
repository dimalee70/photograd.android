package com.example.photograd.android.home.games.domain

import com.example.photograd.android.home.games.data.CurrentGamesRepository
import com.example.photograd.android.home.games.data.DefaultCurrentGamesRepository
import moxy.InjectViewState
import photograd.kz.photograd.presentation.presenter.BasePresenter

/**
 * Created by wokrey@gmail.com on 8/26/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
@InjectViewState
class CurrentGamesPresenter(
    private val repository: CurrentGamesRepository = DefaultCurrentGamesRepository()
): BasePresenter<CurrentGamesView>() {


    fun getCurrentGames(){
        viewState.showProgress()
        disposables.add(
            repository.getCurrentGames()
                .subscribeOn(background)
                .observeOn(mainThread)
                .doFinally {
                    viewState.hideProgress()
                }
                .subscribe(
                    {
                        it.active_games ?: return@subscribe
                        viewState.showCurrentGames(it.active_games)
                    },
                    {
                        viewState.showError(it)
                   }
                )
        )
    }

}