package com.example.photograd.android.auth.login.domain

import android.util.Log
import com.example.photograd.android.auth.login.data.DefaultLoginRepository
import com.example.photograd.android.auth.login.data.LoginRepository
import com.example.photograd.android.auth.login.data.model.LoginRequestModel
import com.example.photograd.android.utils.DataHolder
import moxy.InjectViewState
import photograd.kz.photograd.presentation.presenter.BasePresenter

/**
 * Created by wokrey@gmail.com on 8/26/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
@InjectViewState
class LoginPresenter(
    private val repository: LoginRepository = DefaultLoginRepository()
) : BasePresenter<LoginView>() {

    fun login(email: String, password: String) {
//        val oneSignalId = OneSignal.getPermissionSubscriptionState().subscriptionStatus.userId
        viewState.showProgress()

        val model = LoginRequestModel(
            identificator = email,
            password = password,
            onesignal_player_id = "test"
        )
        disposables.add(
            repository.login(model = model)
                .subscribeOn(background)
                .observeOn(mainThread)
                .doFinally {
                    viewState.hideProgress()
                }
                .subscribe(
                    { result ->
                        DataHolder.user = result.user
                        DataHolder.sessionid = result.session_id
                        viewState.showHome()
                    },
                    {
                       Log.d("login", it.localizedMessage!!)
                    }
                )
        )
    }

    fun loginClicked() {
        viewState.onLoginClicked()
    }

    fun registrationClicked(){
        viewState.showRegistration()
    }
}