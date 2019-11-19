package com.example.photograd.android.home.games.domain

import androidx.lifecycle.MutableLiveData
import com.example.photograd.android.auth.login.data.model.FriendsRequestModel
import com.example.photograd.android.home.games.data.DefaultDuelsRepository
import com.example.photograd.android.home.games.data.DuelsRepository
import com.example.photograd.android.home.games.data.model.FriendsModel
import com.example.photograd.android.utils.DataHolder
import moxy.InjectViewState
import photograd.kz.photograd.presentation.presenter.BasePresenter

@InjectViewState
class DuelsPresenter(
    private val repository: DuelsRepository = DefaultDuelsRepository()
): BasePresenter<DuelsView>() {

    var liveFriendsResponse = MutableLiveData<FriendsModel>()

    fun getFriends(){
        viewState.showProgress()

        val model = FriendsRequestModel(
            offset =  0,
            amount =  10,
            hashId = DataHolder.sessionid
        )
        disposables.add(
            repository.getFriends(model = model)
                .subscribeOn(background)
                .observeOn(mainThread)
                .doFinally{
                    viewState.hideProgress()
                }
                .subscribe(
                    {
                        result ->
                        liveFriendsResponse.value = result
                    },
                    {
                        viewState.showError(it)
                    }
                )
        )
    }

    fun observeForFriendsResponseBoundary(): MutableLiveData<FriendsModel>{
        return liveFriendsResponse
    }
}