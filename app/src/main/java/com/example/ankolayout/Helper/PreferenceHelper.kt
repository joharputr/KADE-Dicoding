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


    fun clearLeague() {
        spe.remove(Constant.id_League).apply()
    }

    fun clearHomeBadge() {
        spe.remove(Constant.gambar_home).apply()
    }

    fun clearAwayBadge() {
        spe.remove(Constant.gambar_away).apply()
    }

    var id_league: String
        set(value) = spe.putString(Constant.id_League, value).apply()
        get() = sp.getString(Constant.id_League, "") ?: ""

    var gambar_home: String
        set(value) = spe.putString(Constant.gambar_home, value).apply()
        get() = sp.getString(Constant.gambar_home, "") ?: ""

    var gambar_away: String
        set(value) = spe.putString(Constant.gambar_away, value).apply()
        get() = sp.getString(Constant.gambar_away, "") ?: ""
}

