package com.example.photograd.android.di

import com.example.photograd.android.home.store.domain.StoreViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by wokrey@gmail.com on 9/6/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */

val storeModule = module {
    viewModel<StoreViewModel> {
        StoreViewModel()
    }
}