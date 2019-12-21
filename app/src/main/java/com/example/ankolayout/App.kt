package com.example.ankolayout

import android.app.Application
import com.example.ankolayout.API.Api
import com.example.ankolayout.API.NetworkAPI
import com.example.ankolayout.Helper.PreferenceHelper

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        api = NetworkAPI.getRetrofit().create(Api::class.java)
        preferenceHelper = PreferenceHelper(this)
    }


    companion object {

        lateinit var api: Api
        var instance: App? = null
        lateinit var preferenceHelper: PreferenceHelper

    }
}