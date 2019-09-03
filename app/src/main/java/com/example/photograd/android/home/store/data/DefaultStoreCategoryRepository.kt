package com.example.photograd.android.home.store.data

import com.example.photograd.android.base.BaseRepository
import com.example.photograd.android.home.store.data.model.OffersData
import com.example.photograd.android.home.store.data.model.StoreCategoryRequestModel
import io.reactivex.Single
import photograd.kz.photograd.models.ApiMethods

/**
 * Created by wokrey@gmail.com on 8/28/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
class DefaultStoreCategoryRepository: BaseRepository(), StoreCategoryRepository {

    override fun getCategoryOffers(model: StoreCategoryRequestModel): Single<OffersData> {

        return makeSocketRequest(
            model = model,
            method = ApiMethods.GET_OFFERS,
            classOf = OffersData::class.java
        )
    }
}