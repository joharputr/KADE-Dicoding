package com.example.ankolayout.API.Pojo.Match


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EventsItemMatch(

    @field:SerializedName("idEvent")
    var idEvent: String? = null,

    @field:SerializedName("intHomeScore")
    val intHomeScore: String? = null,

    @field:SerializedName("intAwayScore")
    val intAwayScore: String? = null,

    @field:SerializedName("strAwayTeam")
    val strAwayTeam: String? = null,

    @field:SerializedName("strHomeTeam")
    val strHomeTeam: String? = null,

    @field:SerializedName("strSport")
    val strSport: String? = null,

    @field:SerializedName("idHomeTeam")
    val idHomeTeam: String? = null,

    @field:SerializedName("idAwayTeam")
    val idAwayTeam: String? = null,

    @field:SerializedName("strTeamBadge")
    val strTeamBadge: String? = null


) : Parcelable