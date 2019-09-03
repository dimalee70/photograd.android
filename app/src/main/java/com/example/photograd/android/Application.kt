package com.example.photograd.android

import android.content.Context
import androidx.multidex.MultiDexApplication
import com.example.photograd.android.di.modules
import org.koin.core.context.startKoin

/**
 * Created by wokrey@gmail.com on 8/26/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
class Application: MultiDexApplication() {

    companion object{
       lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules
        }

        appContext = applicationContext
    }
}