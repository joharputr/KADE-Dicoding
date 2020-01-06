package com.example.ankolayout.Favorite.AnkoSqlite

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FavoriteTeam(
    val id: Long?,
    val idTeam: String,
    val nameTeam: String,
    val descTeam: String,
    val imgTeam: String?
) :
    Parcelable
