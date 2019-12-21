package com.example.ankolayout.API


import com.example.ankolayout.API.Pojo.DetailLeague.Response
import com.example.ankolayout.API.Pojo.DetailMatch.ResponseDetailMatch
import com.example.ankolayout.API.Pojo.Match.ResponseMatch
import com.example.ankolayout.API.Pojo.Match.ResponseSearchMatch
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("lookupleague.php")
    fun get_detail_league(
        @Query(
            "id"
        ) origin: String?
    ): Call<Response>


    @GET("eventspastleague.php")
    fun get_previous_match(
        @Query(
            "id"
        ) origin: String?
    ): Call<ResponseMatch>


    @GET("eventsnextleague.php")
    fun get_next_match(
        @Query(
            "id"
        ) origin: String?
    ): Call<ResponseMatch>


    @GET("lookupevent.php")
    fun get_detail_match(
        @Query(
            "id"
        ) origin: String?
    ): Call<ResponseDetailMatch>

    @GET("searchevents.php")
    fun search_match(
        @Query(
            "e"
        ) origin: String?
    ): Call<ResponseSearchMatch>

}


