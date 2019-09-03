package com.example.photograd.android.home.store.details.data

import io.reactivex.Single

/**
 * Created by wokrey@gmail.com on 9/2/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
interface OfferRepository {

    fun getOfferInfo(offerId: Int): Single<OfferInfo>
}