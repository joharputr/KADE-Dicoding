package com.example.ankolayout.API.Pojo.DetailMatch

import com.google.gson.annotations.SerializedName

data class ResponseDetailMatch(

	@field:SerializedName("events")
	val events: List<EventsItem?>? = null
)