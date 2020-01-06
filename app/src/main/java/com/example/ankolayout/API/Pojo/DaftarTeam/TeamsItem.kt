package com.example.ankolayout.API.Pojo.DaftarTeam

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class TeamsItem(
    val idTeam: String? = null,
    val strAlternate: String? = null,
    val intFormedYear: String? = null,
    val strStadium: String? = null,
    val strTeamBadge: String? = null,
    val strWebsite: String? = null,
    val strTeam: String? = null,
    val strDescriptionEN: String? = null,
    val strSport: String? = null
) : Parcelable
