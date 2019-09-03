package com.example.photograd.android.base

import android.os.Bundle
import android.widget.Toast
import com.example.photograd.android.MainActivity
import moxy.MvpAppCompatFragment

/**
 * Created by wokrey@gmail.com on 8/15/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
abstract class BaseFragment: MvpAppCompatFragment(), BaseView {
    lateinit var activity: MainActivity

    companion object {
        val TAG: String = "BaseFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = getActivity() as MainActivity
    }
    override fun showError(exception: Throwable) {
       Toast.makeText(context, "Error: ${exception.message}", Toast.LENGTH_LONG).show()
    }

    override fun showError(message: String, codeError: Int) {
       
    }

    override fun hideProgress() {
       
    }

    override fun showProgress() {
        Toast.makeText(context, "Loading...", Toast.LENGTH_LONG).show()
    }

    override fun dismissDialogs() {
       
    }

    override fun showRequestSuccessfully(message: String) {
       
    }
}