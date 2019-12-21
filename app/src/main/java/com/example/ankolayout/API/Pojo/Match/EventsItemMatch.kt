package com.example.ankolayout.API.Pojo.Match


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EventsItemMatch(

    @field:SerializedName("idEvent")
    val idEvent: String? = null,

    @field:SerializedName("intHomeScore")
    val intHomeScore: String? = null,

    @field:SerializedName("intAwayScore")
    val intAwayScore: String? = null,
    @field:SerializedName("strAwayTeam")
    val strAwayTeam: String? = null,


    @field:SerializedName("strHomeTeam")
    val strHomeTeam: String? = null

):Parcelable