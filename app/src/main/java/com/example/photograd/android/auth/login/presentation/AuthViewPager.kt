package com.example.photograd.android.auth.login.presentation

/**
 * Created by wokrey@gmail.com on 8/16/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.photograd.android.base.BaseFragment

class AuthViewPager internal constructor(
    fm: FragmentManager,
    behavior: Int = BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
    private var pagesCount: Int = 2
) : FragmentPagerAdapter(fm, behavior) {

    override fun getItem(position: Int): BaseFragment = when (position) {
        0 ->
            LoginFragment.newInstance()
        1 ->
            RegistrationFragment.newInstance()
        else ->
            SmsFragment.newInstance()
    }


    override fun getCount(): Int {

        return pagesCount
    }

    fun setPagesCount(count: Int) {
        pagesCount = count
    }
}