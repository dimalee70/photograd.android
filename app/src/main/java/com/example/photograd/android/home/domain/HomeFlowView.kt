package com.example.photograd.android.home.domain

import com.example.photograd.android.base.BaseView
import com.example.photograd.android.home.data.model.OfferCategory

/**
 * Created by wokrey@gmail.com on 8/28/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
interface HomeFlowView : BaseView{
    fun initViewPager(categories: List<OfferCategory>)
}