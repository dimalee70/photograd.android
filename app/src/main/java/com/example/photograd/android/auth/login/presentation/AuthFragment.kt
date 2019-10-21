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
import com.example.photograd.android.auth.login.presentation.LoginFragment
import com.example.photograd.android.base.BaseFragment
import com.example.photograd.android.databinding.FragmentAuthBinding
import moxy.presenter.InjectPresenter

class AuthFragment : BaseFragment(), LoginView {

    companion object {
        const val TAG: String  = "AuthFragment"
        fun newInstance() = LoginFragment()
    }

    lateinit var binding: FragmentAuthBinding
    lateinit var navController: NavController

    @InjectPresenter
    lateinit var presenter: LoginPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_auth,
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
//        onLogin(LoginType.PHONE)
        println("Hello")
    }

//    override fun onLogin(loginType: LoginType){
//        println("dsdsd")
//    }


}

//
//lateinit var binding: FragmentAuthBinding
//
//override fun onCreateView(
//    inflater: LayoutInflater, container: ViewGroup?,
//    savedInstanceState: Bundle?
//): View? {
//    binding = DataBindingUtil.inflate(
//        inflater,
//        R.layout.fragment_auth,
//        container,
//        false
//    )
//
//    binding.viewPager.adapter = AuthViewPager(childFragmentManager)
//
//    return binding.root
//}
