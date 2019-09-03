package com.example.photograd.android.auth.login.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.photograd.android.R
import com.example.photograd.android.base.BaseFragment
import com.example.photograd.android.databinding.FragmentRegistrationBinding
import com.example.photograd.android.BR
import com.example.photograd.android.auth.login.domain.RegistrationPresenter
import com.example.photograd.android.auth.login.domain.RegistrationView
import moxy.presenter.InjectPresenter

class RegistrationFragment : BaseFragment(), RegistrationView {

    companion object {
        const val TAG: String = "RegistrationFragment"

        fun newInstance() = RegistrationFragment()
    }

    @InjectPresenter
    lateinit var presenter: RegistrationPresenter

    lateinit var binding: FragmentRegistrationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_registration,
            container,
            false
        )

        binding.hideMainInf = false
        binding.notifyPropertyChanged(BR.hideMainInf)
        binding.btnToContinue.setOnClickListener {

        }
        binding.presenter = presenter

        return binding.root
    }

    override fun registerClicked() {
        presenter.register("", "", "", 0, "")
    }

    override fun continueClicked() {
        binding.hideMainInf = true
        binding.notifyPropertyChanged(BR.hideMainInf)
    }

    override fun showHome() {

    }
}
