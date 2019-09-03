package com.example.photograd.android.home.games.presentation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.photograd.android.R
import com.example.photograd.android.base.BaseFragment
import com.example.photograd.android.databinding.FragmentMissionsBinding

class MissionsFragment : BaseFragment() {
    companion object {
        const val TAG: String = "MissionsFragment"
        fun newInstance() = MissionsFragment()
    }

    lateinit var binding: FragmentMissionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_missions, container, false)


        return binding.root
    }


}
