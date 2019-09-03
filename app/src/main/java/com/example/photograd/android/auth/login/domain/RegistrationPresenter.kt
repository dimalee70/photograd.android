package com.example.photograd.android.auth.login.domain

import com.example.photograd.android.auth.login.data.DefaultRegistrationRepository
import com.example.photograd.android.auth.login.data.RegistrationRepository
import moxy.InjectViewState
import photograd.kz.photograd.presentation.presenter.BasePresenter

/**
 * Created by wokrey@gmail.com on 8/26/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
@InjectViewState
class RegistrationPresenter(
    private val repository: RegistrationRepository = DefaultRegistrationRepository()
) : BasePresenter<RegistrationView>() {

    fun register(
        email: String,
        password: String,
        phone: String,
        gender: Int,
        birthday: String
    ) {

    }

    fun continueClick() {
        viewState.continueClicked()
    }

    fun registrationClick() {
        viewState.registerClicked()
    }

}