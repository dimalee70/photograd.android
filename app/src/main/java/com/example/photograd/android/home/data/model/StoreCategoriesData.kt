package com.example.photograd.android.home.data.model

/**
 * Created by wokrey@gmail.com on 8/28/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
class StoreCategoriesData(
    val offer_categories: List<OfferCategory>
)

data class OfferCategory(
    val id: Int,
    val title: String,
    val order_number: Int
)