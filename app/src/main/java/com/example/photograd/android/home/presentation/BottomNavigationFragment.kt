package com.example.photograd.android.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.example.photograd.android.R
import com.example.photograd.android.base.BaseFragment
import com.example.photograd.android.databinding.FragmentBottomNavigationBinding
import com.example.photograd.android.home.domain.BottomNavigationPresenter
import com.example.photograd.android.home.domain.BottomNavigationView
import com.example.photograd.android.utils.DataHolder
import moxy.presenter.InjectPresenter

class BottomNavigationFragment : BaseFragment(), BottomNavigationView {

    companion object {
        const val TAG: String = "BottomNavigationFragment"
        fun newInstance() = BottomNavigationFragment()
    }

    lateinit var binding: FragmentBottomNavigationBinding
    @InjectPresenter
    lateinit var presenter: BottomNavigationPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_bottom_navigation,
            container,
            false
        )

        binding.user = DataHolder.user
        binding.presenter = presenter
        return binding.root
    }

}
