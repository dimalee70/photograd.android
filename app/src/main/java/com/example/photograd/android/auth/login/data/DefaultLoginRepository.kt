package com.example.photograd.android.auth.login.data

import com.example.photograd.android.auth.login.data.model.LoginData
import com.example.photograd.android.auth.login.data.model.LoginRequestModel
import com.example.photograd.android.auth.login.data.model.SocialLoginRequestModel
import com.example.photograd.android.base.BaseRepository
import io.reactivex.Single
import photograd.kz.photograd.models.ApiMethods

/**
 * Created by wokrey@gmail.com on 8/26/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
class DefaultLoginRepository: BaseRepository(), LoginRepository {

    override fun login(model: LoginRequestModel): Single<LoginData> {

        return makeSocketRequest(
            model = model,
            method = ApiMethods.USER_LOGIN,
            classOf = LoginData::class.java
        )
    }

    override fun socialSocketAuth(model: SocialLoginRequestModel): Single<LoginData> {

        return makeSocketRequest(
            model = model,
            method = ApiMethods.SOCIAL_AUTH,
            classOf = LoginData::class.java
        )
    }
}