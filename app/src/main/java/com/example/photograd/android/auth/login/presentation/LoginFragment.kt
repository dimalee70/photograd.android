package com.example.photograd.android.auth.login.presentation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.example.photograd.android.R
import com.example.photograd.android.auth.login.domain.LoginPresenter
import com.example.photograd.android.auth.login.domain.LoginView
import com.example.photograd.android.base.BaseFragment
import com.example.photograd.android.databinding.FragmentLoginBinding
import moxy.presenter.InjectPresenter


class LoginFragment : BaseFragment(), LoginView {

    companion object {
        const val TAG: String = "LoginFragment"
        fun newInstance() = LoginFragment()
    }

    lateinit var binding: FragmentLoginBinding
    lateinit var navController: NavController

    @InjectPresenter
    lateinit var presenter: LoginPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )
        navController = Navigation.findNavController(activity, R.id.navigationHostFragment)
        binding.presenter = presenter

        return binding.root
    }

    override fun onLoginClicked() {
        presenter.login(binding.etLogin.text.toString(), password = binding.etPassword.text.toString())
    }
    override fun showHome() {
        navController.navigate(R.id.homeFlowFragment)
    }

    override fun showRegistration() {
        println("Hello")
//        (parentFragment as AuthFragment?)?.binding?.viewPager?.setCurrentItem(1, true)
    }
}
