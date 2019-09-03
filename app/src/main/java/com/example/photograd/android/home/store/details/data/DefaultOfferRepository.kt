package com.example.photograd.android.home.store.details.data

import com.example.photograd.android.base.BaseRepository
import io.reactivex.Single
import photograd.kz.photograd.models.ApiMethods

/**
 * Created by wokrey@gmail.com on 9/2/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
class DefaultOfferRepository :
    BaseRepository(), OfferRepository {

    override fun getOfferInfo(offerId: Int): Single<OfferInfo> = makeSocketRequest(
        model = OfferRequestModel(offer_id = offerId),
        method = ApiMethods.GET_OFFER_INFO,
        classOf = OfferInfo::class.java
    )
}