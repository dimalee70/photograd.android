package com.example.photograd.android.home.presentation

/**
 * Created by wokrey@gmail.com on 8/28/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
interface Tagger {

    fun getTag(position: Int): String?

    fun getId(position: Int): Int?
}