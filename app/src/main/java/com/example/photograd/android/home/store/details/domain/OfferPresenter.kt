package com.example.photograd.android.home.store.details.domain

import com.example.photograd.android.home.store.details.data.DefaultOfferRepository
import com.example.photograd.android.home.store.details.data.OfferRepository
import moxy.InjectViewState
import photograd.kz.photograd.presentation.presenter.BasePresenter

/**
 * Created by wokrey@gmail.com on 9/2/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
@InjectViewState
class OfferPresenter(
private val repository: OfferRepository = DefaultOfferRepository()
): BasePresenter<OfferView>() {

    fun getOfferInfo(offerId: Int){
        viewState.showProgress()
        disposables.add(
            repository.getOfferInfo(offerId = offerId)
                .subscribeOn(background)
                .observeOn(mainThread)
                .doFinally {
                    viewState.hideProgress()
                }
                .subscribe(
                    {
                        viewState.showOffersInfo(it)
                    },
                    {
                        viewState.showError(it)
                    }
                )
        )
    }
}