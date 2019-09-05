package com.example.photograd.android.home.profile.domain

import com.example.photograd.android.home.profile.data.DefaultProfileRepository
import com.example.photograd.android.home.profile.data.ProfileRepository
import moxy.InjectViewState
import photograd.kz.photograd.presentation.presenter.BasePresenter

/**
 * Created by wokrey@gmail.com on 9/5/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
@InjectViewState
class ProfilePresenter(
    private val repository: ProfileRepository = DefaultProfileRepository()
): BasePresenter<ProfileView>() {

}