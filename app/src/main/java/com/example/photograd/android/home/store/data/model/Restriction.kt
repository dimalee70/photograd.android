package com.example.photograd.android.home.store.data.model

import java.util.Date

/**
 * Created by wokrey@gmail.com on 8/28/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
data class Restriction(
    val purchases_left: Int?,
    val period: Int?,
    val amount_over_period: Int?,
    val next_purchase_available_at: Date
)