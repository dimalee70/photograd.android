package com.example.photograd.android.home.games.data

import com.example.photograd.android.base.BaseRepository
import com.example.photograd.android.home.games.data.model.MissionsData
import com.example.photograd.android.utils.DataHolder
import io.reactivex.Single
import photograd.kz.photograd.models.ApiMethods

/**
 * Created by wokrey@gmail.com on 8/26/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
class DefaultMissionsRepository: BaseRepository(), MissionsRepository {
    override fun getMissions(): Single<MissionsData> {
        return makeSocketRequest(
            model = null,
            method = ApiMethods.GET_MISSIONS,
            classOf = MissionsData::class.java)
    }
}