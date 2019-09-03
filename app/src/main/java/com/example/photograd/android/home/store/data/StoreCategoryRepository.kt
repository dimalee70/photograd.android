package com.example.photograd.android.home.store.data

import com.example.photograd.android.home.store.data.model.OffersData
import com.example.photograd.android.home.store.data.model.StoreCategoryRequestModel
import io.reactivex.Single

/**
 * Created by wokrey@gmail.com on 8/28/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
interface StoreCategoryRepository {

    fun getCategoryOffers(model: StoreCategoryRequestModel): Single<OffersData>
}