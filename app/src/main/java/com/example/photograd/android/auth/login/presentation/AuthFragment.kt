package com.example.photograd.android.auth.login.presentation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.example.photograd.android.R
import com.example.photograd.android.auth.login.presentation.LoginFragment
import com.example.photograd.android.base.BaseFragment
import com.example.photograd.android.databinding.FragmentAuthBinding

class AuthFragment : BaseFragment() {

    companion object {
        const val TAG: String  = "AuthFragment"
        fun newInstance() = LoginFragment()
    }

    lateinit var binding: FragmentAuthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_auth,
            container,
            false
        )

        binding.viewPager.adapter = AuthViewPager(childFragmentManager)

        return binding.root
    }


}
