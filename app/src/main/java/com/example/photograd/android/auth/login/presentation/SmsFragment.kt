package com.example.photograd.android.auth.login.presentation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.photograd.android.R
import com.example.photograd.android.base.BaseFragment


class SmsFragment : BaseFragment() {

    companion object{
        const val TAG: String = "SmsFragment"
        fun newInstance() = SmsFragment()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_sms, container, false)
    }


}
