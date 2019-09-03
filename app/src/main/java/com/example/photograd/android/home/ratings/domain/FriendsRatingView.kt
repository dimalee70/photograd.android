package com.example.photograd.android.home.ratings.domain

import com.example.photograd.android.base.BaseView
import com.example.photograd.android.home.ratings.data.model.RatedUser

/**
 * Created by wokrey@gmail.com on 9/3/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
interface FriendsRatingView: BaseView {

    fun showRating(topRating: List<RatedUser>, rating: List<RatedUser>)
}