package com.example.photograd.android.auth


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.photograd.android.R
import com.example.photograd.android.base.BaseFragment
import com.example.photograd.android.databinding.FragmentLanguageBinding


class LanguageFragment : BaseFragment() {

    companion object {
        const val TAG: String = "LanguageFragment"

        fun newInstance() = LanguageFragment()
    }


    lateinit var binding: FragmentLanguageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_language, container, false)
        binding.btnContinue.setOnClickListener {
            activity.navController.navigate(R.id.authFragment)
        }
        return binding.root
    }


}
