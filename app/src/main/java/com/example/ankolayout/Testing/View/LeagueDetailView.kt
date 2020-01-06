package com.example.ankolayout.Testing.View

import com.example.ankolayout.API.Pojo.DetailLeague.Response

interface LeagueDetailView : View<Response> {
    fun onShowLoading()
    fun onHideLoading()
}

