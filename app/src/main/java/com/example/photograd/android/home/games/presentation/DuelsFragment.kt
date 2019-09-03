package com.example.photograd.android.home.games.presentation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.photograd.android.R
import com.example.photograd.android.base.BaseFragment


class DuelsFragment : BaseFragment() {

    companion object{
        const val TAG: String = "DuelsFragment"
        fun newInstance() = DuelsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_duels, container, false)
    }


}
