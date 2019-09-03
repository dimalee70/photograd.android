package com.example.photograd.android.home.ratings.data

import com.example.photograd.android.base.BaseRepository
import com.example.photograd.android.home.ratings.data.model.RatingData
import io.reactivex.Single
import photograd.kz.photograd.models.ApiMethods

/**
 * Created by wokrey@gmail.com on 9/3/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
class DefaultRatingRepository
    :BaseRepository(), RatingRepository{

    override fun getRating(): Single<RatingData> {

        return makeSocketRequest(
            model = null,
            method = ApiMethods.GET_TOP_RATING,
            classOf = RatingData::class.java
        )
    }
}