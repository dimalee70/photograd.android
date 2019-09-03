package com.example.photograd.android.home.ratings.data

import com.example.photograd.android.home.ratings.data.model.RatingData
import io.reactivex.Single

/**
 * Created by wokrey@gmail.com on 9/3/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
interface RatingRepository {

    fun getRating(): Single<RatingData>
}