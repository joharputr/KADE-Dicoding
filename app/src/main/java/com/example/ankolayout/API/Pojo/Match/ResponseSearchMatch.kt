package com.example.ankolayout.API.Pojo.Match

import com.google.gson.annotations.SerializedName

data class ResponseSearchMatch(

    @field:SerializedName("event")
    val events: List<EventsItemMatch?>? = null
)