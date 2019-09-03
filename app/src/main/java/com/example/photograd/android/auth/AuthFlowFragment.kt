package com.example.photograd.android.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.photograd.android.R
import com.example.photograd.android.base.BaseFragment
import com.example.photograd.android.databinding.FragmentAuthFlowBinding

class AuthFlowFragment : BaseFragment() {
    companion object{
        val TAG: String  = "AuthFlowFragment"
        fun newInstance() = AuthFlowFragment()
    }

    lateinit var binding: FragmentAuthFlowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_auth_flow,
            container,
            false
        )
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        showLanguage()
    }

    fun showLanguage(){
        var videoFragment =
            childFragmentManager.findFragmentById(R.id.language_frame_layout) as LanguageFragment?

        if (videoFragment == null) {
            videoFragment = LanguageFragment.newInstance()

            childFragmentManager
                .beginTransaction()
                .add(R.id.language_frame_layout, videoFragment)
                .commit()
        }
    }

}
