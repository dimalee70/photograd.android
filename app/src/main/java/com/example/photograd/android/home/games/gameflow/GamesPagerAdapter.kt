package com.example.photograd.android.home.games.gameflow

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.photograd.android.home.games.gameflow.game.presentation.GameFragment
import com.example.photograd.android.home.games.presentation.CurrentGamesFragment

/**
 * Created by wokrey@gmail.com on 8/21/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
class GamesPagerAdapter(
    fm: FragmentManager,
    behavior: Int = BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
    private var pagesCount: Int = 2
): FragmentStatePagerAdapter(fm, behavior) {
    override fun getItem(position: Int): Fragment =when(position){
        0 -> GameFragment.newInstance()
        1 -> GameFragment.newInstance()
        2 -> GameFragment.newInstance()
        3 -> GameFragment.newInstance()
        4 -> GameFragment.newInstance()
        5 -> GameFragment.newInstance()
        else -> CurrentGamesFragment.newInstance()
    }

    override fun getCount(): Int  = 6

}