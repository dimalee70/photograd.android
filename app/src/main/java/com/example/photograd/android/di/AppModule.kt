package com.example.photograd.android.di

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.example.photograd.android.BuildConfig
import com.example.photograd.android.base.ApiService
import com.example.photograd.android.utils.Constants
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import photograd.kz.photograd.api.SocketListener
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by wokrey@gmail.com on 8/14/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */

val appModule = module {
    single<OkHttpClient> {
        OkHttpClient.Builder()
            .readTimeout(Constants.readTimeout, TimeUnit.SECONDS)
            .writeTimeout(Constants.writeTimeout, TimeUnit.SECONDS)
            .pingInterval(Constants.PING_INTERFAL, TimeUnit.SECONDS)
            .connectTimeout(Constants.connectTimeout, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()
    }

    single<SharedPreferences> {
        PreferenceManager.getDefaultSharedPreferences(androidApplication().applicationContext)
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("http://185.146.1.56/api/")
            .client(get())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(ApiService::class.java)
    }
}