package com.example.photograd.android.home.store.domain

import com.example.photograd.android.home.store.data.DefaultStoreCategoryRepository
import com.example.photograd.android.home.store.data.StoreCategoryRepository
import com.example.photograd.android.home.store.data.model.Offer
import com.example.photograd.android.home.store.data.model.StoreCategoryRequestModel
import moxy.InjectViewState
import photograd.kz.photograd.presentation.presenter.BasePresenter

/**
 * Created by wokrey@gmail.com on 8/28/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
@InjectViewState
class StoreCategoryPresenter(
    private val repository: StoreCategoryRepository = DefaultStoreCategoryRepository()
): BasePresenter<StoreCategoryView>() {

    var data: List<Offer>? = null

    fun getCategoryOffers(categoryId: Int?){
        categoryId ?: return

        val model = StoreCategoryRequestModel(category_id = categoryId)
        disposables.add(
            repository.getCategoryOffers(model)
                .subscribeOn(background)
                .observeOn(mainThread)
                .subscribe(
                    {
                        data = it.offers
                        viewState.showOffers(it.offers)
                    },
                    {
                        viewState.showError(it)
                    }
                )
        )
    }
}