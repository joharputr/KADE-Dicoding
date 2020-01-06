package com.example.ankolayout.Testing.Presenter

import com.example.ankolayout.API.Api
import com.example.ankolayout.API.NetworkAPI
import com.example.ankolayout.API.Pojo.DetailLeague.Response
import com.example.ankolayout.API.Pojo.DetailMatch.ResponseDetailMatch
import com.example.ankolayout.API.Pojo.Match.ResponseMatch
import com.example.ankolayout.API.Pojo.Match.ResponseSearchMatch
import com.example.ankolayout.Testing.View.View
import retrofit2.Call
import retrofit2.Callback

class Repository() {

    fun get_detail_league(
        league: String?,
        view: View<Response?>
    ) {

        NetworkAPI.getRetrofit().create(Api::class.java).get_detail_league(league)
            .enqueue(object : Callback<Response> {
                override fun onFailure(call: Call<Response>, t: Throwable) {
                    view.onDataError()
                }

                override fun onResponse(
                    call: Call<Response>,
                    response: retrofit2.Response<Response>
                ) {
                    val data = response.body()
                    view.onDataLoaded(data)
                }
            })
    }


    fun next_match(
        league: String?,
        view: View<ResponseMatch?>
    ) {

        NetworkAPI.getRetrofit().create(Api::class.java).get_next_match(league)
            .enqueue(object : Callback<ResponseMatch> {
                override fun onFailure(call: Call<ResponseMatch>, t: Throwable) {
                    view.onDataError()
                }

                override fun onResponse(
                    call: Call<ResponseMatch>,
                    response: retrofit2.Response<ResponseMatch>
                ) {
                    val data = response.body()
                    view.onDataLoaded(data)
                }
            })
    }

    fun prev_match(
        league: String?,
        view: View<ResponseMatch?>
    ) {

        NetworkAPI.getRetrofit().create(Api::class.java).get_previous_match(league)
            .enqueue(object : Callback<ResponseMatch> {
                override fun onFailure(call: Call<ResponseMatch>, t: Throwable) {
                    view.onDataError()
                }

                override fun onResponse(
                    call: Call<ResponseMatch>,
                    response: retrofit2.Response<ResponseMatch>
                ) {
                    val data = response.body()
                    view.onDataLoaded(data)
                }
            })
    }


    fun get_detail_match(
        league: String?,
        view: View<ResponseDetailMatch?>
    ) {

        NetworkAPI.getRetrofit().create(Api::class.java).get_detail_match(league)
            .enqueue(object : Callback<ResponseDetailMatch> {
                override fun onFailure(call: Call<ResponseDetailMatch>, t: Throwable) {
                    view.onDataError()
                }

                override fun onResponse(
                    call: Call<ResponseDetailMatch>,
                    response: retrofit2.Response<ResponseDetailMatch>
                ) {
                    val data = response.body()
                    view.onDataLoaded(data)
                }
            })
    }


    fun get_search_match(
        league: String?,
        view: View<ResponseSearchMatch?>
    ) {

        NetworkAPI.getRetrofit().create(Api::class.java).search_match(league)
            .enqueue(object : Callback<ResponseSearchMatch> {
                override fun onFailure(call: Call<ResponseSearchMatch>, t: Throwable) {
                    view.onDataError()
                }

                override fun onResponse(
                    call: Call<ResponseSearchMatch>,
                    response: retrofit2.Response<ResponseSearchMatch>
                ) {
                    val data = response.body()
                    view.onDataLoaded(data)
                }
            })
    }
}
