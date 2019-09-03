package com.example.photograd.android.home.ratings.domain

import com.example.photograd.android.home.ratings.data.DefaultRatingRepository
import com.example.photograd.android.home.ratings.data.RatingRepository
import com.example.photograd.android.home.ratings.data.model.RatedUser
import moxy.InjectViewState
import photograd.kz.photograd.presentation.presenter.BasePresenter

/**
 * Created by wokrey@gmail.com on 9/3/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
@InjectViewState
class RatingPresenter(
    private val repository: RatingRepository = DefaultRatingRepository()
): BasePresenter<RatingView>() {

    private var topRating: List<RatedUser>? = null
    private var rating: List<RatedUser>? = null

    fun getRating(){
        viewState.showProgress()
        disposables.add(
            repository.getRating()
                .subscribeOn(background)
                .observeOn(mainThread)
                .doFinally {
                    viewState.hideProgress()
                }
                .subscribe(
                    {
                        topRating = it.rating.subList(0, 10).toMutableList()
                        rating = it.rating.subList(10, it.rating.size-1)
                        viewState.showRating(topRating = topRating!!, rating = rating!!)
                    },
                    {
                        viewState.showError(it)
                    }
                )
        )
    }
}