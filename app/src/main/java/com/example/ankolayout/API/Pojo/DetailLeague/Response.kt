package com.example.ankolayout.API.Pojo.DetailLeague


import com.example.ankolayout.API.Pojo.DetailLeague.LeaguesItem
import com.google.gson.annotations.SerializedName


data class Response(

	@field:SerializedName("leagues")
	val leagues: List<LeaguesItem?>? = null
)