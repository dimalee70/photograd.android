package com.example.photograd.android.home.games.domain

import com.example.photograd.android.home.games.data.DefaultDuelsRepository
import com.example.photograd.android.home.games.data.DuelsRepository
import moxy.InjectViewState
import photograd.kz.photograd.presentation.presenter.BasePresenter

/**
 * Created by wokrey@gmail.com on 8/26/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
@InjectViewState
class DuelsPresenter(
    private val repository: DuelsRepository = DefaultDuelsRepository()
): BasePresenter<DuelsView>() {
}