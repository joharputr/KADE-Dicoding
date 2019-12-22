package com.example.ankolayout.Favorite.AnkoSqlite

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FavoriteData(
    val id: Long?,
    val idEvent: String,
    val homeTeam: String,
    val awayTeam: String,
    val homeScore: String?,
    val awayScore: String?
) :
    Parcelable
