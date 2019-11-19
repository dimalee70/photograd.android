package com.example.photograd.android.home.games.data

import com.example.photograd.android.auth.login.data.model.FriendsRequestModel
import com.example.photograd.android.home.games.data.model.FriendsModel
import io.reactivex.Single

/**
 * Created by wokrey@gmail.com on 8/26/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
interface DuelsRepository {
    fun getFriends(model: FriendsRequestModel): Single<FriendsModel>
}