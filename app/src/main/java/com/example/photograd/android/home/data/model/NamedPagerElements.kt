package com.example.photograd.android.home.data.model

/**
 * Created by wokrey@gmail.com on 8/28/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */

//Wrapper for fragments
class NamedPagerElements(
    /**
     * Fragment's TAG
     * */
    val tag: String,
    /**
     * use categoryId for Categories from store
     * */
    val categoryId: Int? = null
)