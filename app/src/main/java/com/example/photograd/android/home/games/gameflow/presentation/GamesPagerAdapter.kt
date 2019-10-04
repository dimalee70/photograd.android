package com.example.photograd.android.home.games.gameflow.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.photograd.android.home.games.gameflow.current.presentation.CurrentGameFragment
import com.example.photograd.android.home.games.presentation.CurrentGamesFragment

/**
 * Created by wokrey@gmail.com on 8/21/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
class GamesPagerAdapter(
    fm: FragmentManager,
    behavior: Int = BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
    private val idList: List<Int>
): FragmentStatePagerAdapter(fm, behavior) {
    override fun getItem(position: Int): Fragment =when(position){
        0 -> CurrentGameFragment.newInstance()
        1 -> CurrentGameFragment.newInstance()
        2 -> CurrentGameFragment.newInstance()
        3 -> CurrentGameFragment.newInstance()
        4 -> CurrentGameFragment.newInstance()
        5 -> CurrentGameFragment.newInstance()
        else -> CurrentGamesFragment.newInstance()
    }

    override fun getCount(): Int  = idList.size

}