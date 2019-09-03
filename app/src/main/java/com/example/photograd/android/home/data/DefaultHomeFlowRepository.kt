package com.example.photograd.android.home.data

import com.example.photograd.android.base.BaseRepository
import com.example.photograd.android.home.data.model.StoreCategoriesData
import io.reactivex.Single
import photograd.kz.photograd.models.ApiMethods

/**
 * Created by wokrey@gmail.com on 8/28/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
class DefaultHomeFlowRepository: BaseRepository(), HomeFlowRepository {

    override fun getStoreCategories(): Single<StoreCategoriesData> {

        return makeSocketRequest(
            model = null,
            method = ApiMethods.GET_OFFER_CATEGORIES,
            classOf = StoreCategoriesData::class.java
        )
    }
}