package com.example.ankolayout.API.Pojo.Dummy

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataLeague(
    val id: Int,
    val title: String,
    val description: String,
    val imageView: Int
    , val gambar: String
) : Parcelable
