package com.example.ankolayout.API.Pojo.Klasemen

import com.google.gson.annotations.SerializedName

data class TableItem_klasemen(

    @field:SerializedName("teamid")
    val teamid: String? = null,


    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("played")
    val played: Int? = null,

    @field:SerializedName("win")
    val win: Int? = null,

    @field:SerializedName("loss")
    val loss: Int? = null,

    @field:SerializedName("draw")
    val draw: Int? = null,

    @field:SerializedName("total")
    val total: Int? = null


)