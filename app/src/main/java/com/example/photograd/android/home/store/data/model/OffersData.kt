package com.example.photograd.android.home.store.data.model

import com.example.photograd.android.auth.models.User
import com.example.photograd.android.base.models.InGameNotification

/**
 * Created by wokrey@gmail.com on 8/28/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
data class OffersData(
    val offers: List<Offer>,
    val notifications: List<InGameNotification>,
    val user: User?
)

data class StoreCategoryRequestModel(
    val category_id: Int,
    val offer_types: List<Int> = ArrayList(),
    val sorting_field: String? = null,
    val offset: Int = 0,
    val amount: Int = 10,
    val longitude: Float? = null,
    val latitude: Float? = null
)