package com.example.photograd.android.home.domain

import com.example.photograd.android.home.data.DefaultHomeFlowRepository
import com.example.photograd.android.home.data.HomeFlowRepository
import moxy.InjectViewState
import photograd.kz.photograd.presentation.presenter.BasePresenter

/**
 * Created by wokrey@gmail.com on 8/28/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
@InjectViewState
class HomeFlowPresenter(
    private val repository: HomeFlowRepository = DefaultHomeFlowRepository()
): BasePresenter<HomeFlowView>() {

    fun getStoreCategories(){
        viewState.showProgress()
        disposables.add(
            repository.getStoreCategories()
                .subscribeOn(background)
                .observeOn(mainThread)
                .doFinally { viewState.hideProgress() }
                .subscribe(
                    {
                        viewState.initViewPager(it.offer_categories)
                    },
                    {
                        viewState.showError(it)
                    }
                )
        )
    }
}