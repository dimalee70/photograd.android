package com.example.photograd.android.auth.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.photograd.android.BR

/**
 * Created by wokrey@gmail.com on 8/19/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
data class Image(
    val id: Int,
    val path: String?,
    val hashkey: String?
) : BaseObservable() {
    var url: String = ""
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.url)
        }
}