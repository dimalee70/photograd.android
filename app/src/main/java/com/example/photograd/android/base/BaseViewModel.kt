package com.example.photograd.android.base

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.lang.Exception

/**
 * Created by wokrey@gmail.com on 9/6/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
open class BaseViewModel(
    protected val disposables: CompositeDisposable = CompositeDisposable(),
    protected val background: Scheduler = Schedulers.io(),
    protected val mainThread: Scheduler = AndroidSchedulers.mainThread()
): ViewModel() {

    private val errorLD = MediatorLiveData<Exception>()
    private val loadingStatusLD = MediatorLiveData<Boolean>().apply {
        value = false
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }


    //getters
    fun getErrorLD() = errorLD
    fun getLoadingLD() = loadingStatusLD
}