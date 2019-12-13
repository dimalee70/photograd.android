package com.example.photograd.android.home.games.domain

import androidx.lifecycle.MutableLiveData
import com.example.photograd.android.home.games.data.DefaultMissionsRepository
import com.example.photograd.android.home.games.data.MissionsRepository
import com.example.photograd.android.home.games.data.model.FriendsModel
import com.example.photograd.android.home.games.data.model.MissionsData
import com.example.photograd.android.utils.DataHolder
import moxy.InjectViewState
import photograd.kz.photograd.presentation.presenter.BasePresenter

/**
 * Created by wokrey@gmail.com on 8/26/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
@InjectViewState
class MissionsPresenter (
    private val repository: MissionsRepository = DefaultMissionsRepository()
): BasePresenter<MissionsView>() {

    var liveMissionResponse = MutableLiveData<MissionsData>()

    fun getMission(){
        viewState.showProgress()

//
        disposables.add(
            repository.getMissions()
                .subscribeOn(background)
                .observeOn(mainThread)
                .doFinally{
                    viewState.hideProgress()
                }
                .subscribe(
                    { result ->
                        liveMissionResponse.value = result
//                        println(result)
                    },
                    {
                        viewState.showError(it)
                    })
        )
    }

    fun observeForMissionsResponseBoundary(): MutableLiveData<MissionsData>{
        return liveMissionResponse
    }

}