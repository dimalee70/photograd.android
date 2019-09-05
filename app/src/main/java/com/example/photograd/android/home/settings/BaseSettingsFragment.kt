package com.example.photograd.android.home.settings


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.photograd.android.R
import com.example.photograd.android.base.BaseFragment

class BaseSettingsFragment : BaseFragment() {

    companion object{
        const val TAG = "BaseSettingsFragment"
        fun newInstance() = BaseSettingsFragment()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_base_settings, container, false)
    }


}
