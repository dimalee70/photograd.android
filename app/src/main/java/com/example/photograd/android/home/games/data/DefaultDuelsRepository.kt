package com.example.photograd.android.home.games.data

import com.example.photograd.android.auth.login.data.model.FriendsRequestModel
import com.example.photograd.android.base.BaseRepository
import com.example.photograd.android.home.games.data.model.FriendsModel
import io.reactivex.Single
import photograd.kz.photograd.models.ApiMethods

/**
 * Created by wokrey@gmail.com on 8/26/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
class DefaultDuelsRepository: BaseRepository(), DuelsRepository {
    override fun getFriends(model: FriendsRequestModel): Single<FriendsModel> {
        return makeSocketRequest(
            model = model,
            method = ApiMethods.GET_FRIENDS,
            classOf = FriendsModel::class.java
        )
    }
}