package com.example.photograd.android.home.ratings.domain

import com.example.photograd.android.home.ratings.data.DefaultFriendsRatingRepository
import com.example.photograd.android.home.ratings.data.FriendsRatingRepository
import com.example.photograd.android.home.ratings.data.model.RatedUser
import moxy.InjectViewState
import photograd.kz.photograd.presentation.presenter.BasePresenter

/**
 * Created by wokrey@gmail.com on 9/3/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
@InjectViewState
class FriendsRatingPresenter(
    private val repository: FriendsRatingRepository = DefaultFriendsRatingRepository()
) : BasePresenter<FriendsRatingView>() {

    private var response: MutableList<RatedUser>? = null
    private var topRating: List<RatedUser>? = null
    private var rating: List<RatedUser>? = null

    fun getRatings() {
        viewState.showProgress()
        disposables.add(
            repository.getRatings()
                .subscribeOn(background)
                .observeOn(mainThread)
                .doFinally {
                    viewState.hideProgress()
                }
                .subscribe(
                    { data ->
                        response = data.rating.sortedBy {
                            it.rating
                        }.toMutableList()

                        for (i in response!!.indices) {
                            response!![i].rank = i + 1
                        }

                        val topCount = data.rating.size / 4
                        topRating = response!!.subList(0, topCount)
                        rating = response!!.subList(topCount, response!!.size)


                        viewState.showRating(topRating = topRating!!, rating = rating!!)
                    },
                    {
                        viewState.showError(it)
                    }
                )
        )
    }
}