package com.example.photograd.android.home.profile.presentation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.photograd.android.R
import com.example.photograd.android.base.BaseFragment
import com.example.photograd.android.databinding.FragmentProfileBinding
import com.example.photograd.android.home.profile.domain.ProfilePresenter
import com.example.photograd.android.home.profile.domain.ProfileView
import moxy.presenter.InjectPresenter

class ProfileFragment : BaseFragment(), ProfileView {

    companion object {
        const val TAG = "ProfileFragment"

        fun newInstance() = ProfileFragment()
    }

    lateinit var binding: FragmentProfileBinding

    @InjectPresenter
    lateinit var presenter: ProfilePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)

        return binding.root
    }

}
