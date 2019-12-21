package com.example.ankolayout.Helper

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper(app: Application) {
    private val sp: SharedPreferences by lazy {
        app.getSharedPreferences("binar_app", Context.MODE_PRIVATE)
    }

    private val spe: SharedPreferences.Editor by lazy {
        sp.edit()
    }

    fun clearAll() {
        spe.clear().apply()
    }
    var id_team: String
        set(value) = spe.putString(Constant.id_team, value).apply()
        get() = sp.getString(Constant.id_team, "") ?: ""
}

