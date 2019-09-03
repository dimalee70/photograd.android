package com.example.photograd.android.home.games.gameflow


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.photograd.android.R
import com.example.photograd.android.base.BaseFragment
import com.example.photograd.android.databinding.FragmentGameFlowBinding
import com.google.android.material.tabs.TabLayout


class GameFLowFragment : BaseFragment() {

    companion object {
        const val TAG: String = "GameFLowFragment"
        fun newInstance() = GameFLowFragment()
    }

    lateinit var binding: FragmentGameFlowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_flow, container, false)
        binding.vpGames.adapter = GamesPagerAdapter(childFragmentManager!!)
        binding.vpGames.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayoutGames))
        addTabs()

        return binding.root
    }

    private fun addTabs() {
        binding.tabLayoutGames.addTab(binding.tabLayoutGames.newTab().setText("Чепушь 1"))
        binding.tabLayoutGames.addTab(binding.tabLayoutGames.newTab().setText("Чепушь 2"))
        binding.tabLayoutGames.addTab(binding.tabLayoutGames.newTab().setText("Чепушь 3"))
        binding.tabLayoutGames.addTab(binding.tabLayoutGames.newTab().setText("Чепушь 4"))
        binding.tabLayoutGames.addTab(binding.tabLayoutGames.newTab().setText("Чепушь 5"))
        binding.tabLayoutGames.addTab(binding.tabLayoutGames.newTab().setText("Чепушь 6"))
        binding.tabLayoutGames.addTab(binding.tabLayoutGames.newTab().setText("Чепушь 7"))
    }

}
