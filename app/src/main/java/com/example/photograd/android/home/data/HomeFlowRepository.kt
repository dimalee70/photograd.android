package com.example.photograd.android.home.data

import com.example.photograd.android.home.data.model.StoreCategoriesData
import io.reactivex.Single

/**
 * Created by wokrey@gmail.com on 8/28/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
interface HomeFlowRepository {

    fun getStoreCategories(): Single<StoreCategoriesData>
}