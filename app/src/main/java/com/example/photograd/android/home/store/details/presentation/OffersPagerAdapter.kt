package com.example.photograd.android.home.store.details.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

/**
 * Created by wokrey@gmail.com on 9/2/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
class OffersPagerAdapter(
    fm: FragmentManager,
    behavior: Int = BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
    private var pagesCount: Int = 2,
    private var offersId: List<Int>
): FragmentStatePagerAdapter(fm, behavior) {
    override fun getItem(position: Int): Fragment = OfferFragment.newInstance(
        id = offersId[position]
    )

    override fun getCount(): Int  = pagesCount

}