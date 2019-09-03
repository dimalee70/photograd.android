package com.example.photograd.android.auth.login.data

import com.example.photograd.android.auth.login.data.model.LoginData
import com.example.photograd.android.auth.login.data.model.LoginRequestModel
import com.example.photograd.android.auth.login.data.model.SocialLoginRequestModel
import io.reactivex.Single

/**
 * Created by wokrey@gmail.com on 8/26/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
interface LoginRepository {

    fun login(model: LoginRequestModel): Single<LoginData>

    fun socialSocketAuth(model: SocialLoginRequestModel): Single<LoginData>
}