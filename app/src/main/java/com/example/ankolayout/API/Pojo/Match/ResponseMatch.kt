package com.example.ankolayout.API.Pojo.Match

import com.google.gson.annotations.SerializedName


data class ResponseMatch(

    @field:SerializedName("events")
    val events: List<EventsItemMatch?>? = null
)