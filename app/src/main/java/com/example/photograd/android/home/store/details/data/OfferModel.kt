package com.example.photograd.android.home.store.details.data

/**
 * Created by wokrey@gmail.com on 9/2/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */

data class OfferRequestModel(
    val offer_id: Int
)
data class OfferInfo(
    val purchase_days_valid: Int,
    val address: String,
    val work_schedule: String,
    val phone_numbers: String,
    val average_bill: String,
    val fb_link: String,
    val instagram_link: String,
    val site_link: String,
    val note: String,
    val reviews_amount: Int
)