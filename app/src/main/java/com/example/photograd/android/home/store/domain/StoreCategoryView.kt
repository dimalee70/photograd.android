package com.example.photograd.android.home.store.domain

import com.example.photograd.android.base.BaseView
import com.example.photograd.android.home.store.data.model.Offer

/**
 * Created by wokrey@gmail.com on 8/28/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
interface StoreCategoryView: BaseView {

    fun showOffers(offers: List<Offer>)
}