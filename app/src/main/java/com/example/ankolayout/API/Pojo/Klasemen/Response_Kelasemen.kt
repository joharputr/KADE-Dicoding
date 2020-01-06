package com.example.ankolayout.API.Pojo.Klasemen

import com.google.gson.annotations.SerializedName

data class Response_Kelasemen(

	@field:SerializedName("table")
	val table: List<TableItem_klasemen?>? = null
)