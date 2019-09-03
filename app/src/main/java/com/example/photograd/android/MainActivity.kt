package com.example.photograd.android

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import moxy.MvpAppCompatActivity
import photograd.kz.photograd.api.SocketEventsManager

class MainActivity : MvpAppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.navigationHostFragment)
    }

    override fun onStart() {
        super.onStart()
        SocketEventsManager.connect()
    }

    override fun onStop() {
        super.onStop()
        SocketEventsManager.close(1000, "onPause")
    }
}
