package com.example.photograd.android.home.store.details.domain

import com.example.photograd.android.base.BaseView
import com.example.photograd.android.home.store.details.data.OfferInfo

/**
 * Created by wokrey@gmail.com on 9/2/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
interface OfferView: BaseView {

    fun showOffersInfo(offerInfo: OfferInfo)
}