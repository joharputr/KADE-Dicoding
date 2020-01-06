package com.example.ankolayout.Testing.Presenter

import com.example.ankolayout.API.Pojo.DetailLeague.Response
import com.example.ankolayout.API.Pojo.DetailMatch.ResponseDetailMatch
import com.example.ankolayout.API.Pojo.Match.ResponseMatch
import com.example.ankolayout.API.Pojo.Match.ResponseSearchMatch
import com.example.ankolayout.Testing.View.*

class Presenter(
    private val view_detail_league: LeagueDetailView,
    private val match: Match,
    private val search_view: Search,
    private val detail_match: detailMatch,
    private val matchRepository: Repository
) {

    fun getLeagueDetail(id: String) {
        view_detail_league.onShowLoading()
        matchRepository.get_detail_league(id, object : View<Response?> {
            override fun onDataLoaded(data: Response?) {
                view_detail_league.onDataLoaded(data)
            }

            override fun onDataError() {
                view_detail_league.onDataError()
            }

        })
        view_detail_league.onHideLoading()
    }

    fun get_next_match(id: String) {
        match.onShowLoading()
        matchRepository.next_match(id, object : View<ResponseMatch?> {
            override fun onDataLoaded(data: ResponseMatch?) {
                match.onDataLoaded(data)
            }

            override fun onDataError() {
                match.onDataError()
            }


        })
        match.onHideLoading()
    }


    fun get_prev_match(id: String) {
        match.onShowLoading()
        matchRepository.prev_match(id, object : View<ResponseMatch?> {
            override fun onDataLoaded(data: ResponseMatch?) {
                match.onDataLoaded(data)
            }

            override fun onDataError() {
                match.onDataError()
            }


        })
        match.onHideLoading()
    }

    fun get_search(id: String) {
        search_view.onShowLoading()
        matchRepository.get_search_match(id, object : View<ResponseSearchMatch?> {
            override fun onDataLoaded(data: ResponseSearchMatch?) {
                search_view.onDataLoaded(data)
            }

            override fun onDataError() {
                search_view.onDataError()
            }


        })
        search_view.onHideLoading()
    }

    fun get_detail_match(id: String) {
        detail_match.onShowLoading()
        matchRepository.get_detail_match(id, object : View<ResponseDetailMatch?> {
            override fun onDataLoaded(data: ResponseDetailMatch?) {
                detail_match.onDataLoaded(data)
            }

            override fun onDataError() {
                detail_match.onDataError()
            }


        })
        detail_match.onHideLoading()
    }
}