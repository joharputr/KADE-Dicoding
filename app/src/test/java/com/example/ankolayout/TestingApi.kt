package com.example.ankolayout

import com.example.ankolayout.API.Pojo.DetailLeague.Response
import com.example.ankolayout.API.Pojo.DetailMatch.ResponseDetailMatch
import com.example.ankolayout.API.Pojo.Match.ResponseMatch
import com.example.ankolayout.API.Pojo.Match.ResponseSearchMatch
import com.example.ankolayout.Testing.Presenter.Presenter
import com.example.ankolayout.Testing.Presenter.Repository
import com.example.ankolayout.Testing.View.*
import com.nhaarman.mockito_kotlin.argumentCaptor
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class TestingApi {

    @Mock
    private lateinit var view_detail_league: LeagueDetailView

    @Mock
    private lateinit var view_match: Match

    @Mock
    private lateinit var view_prev_match: Match

    @Mock
    private lateinit var view_search: Search

    @Mock
    private lateinit var view_detail_match: detailMatch


    //presenter
    @Mock
    private lateinit var matchRepository: Repository


    //Data
    @Mock
    private lateinit var detailLeague: Response

    @Mock
    private lateinit var match: ResponseMatch

    @Mock
    private lateinit var search_match: ResponseSearchMatch


    @Mock
    private lateinit var detail_match: ResponseDetailMatch


    private lateinit var matchPresenter: Presenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        matchPresenter =
            Presenter(
                view_detail_league,
                view_match,
                view_search,
                view_detail_match,
                matchRepository
            )
    }


    //detail league
    @Test
    fun get_detail_league_test() {

        val id = "4332"

        matchPresenter.getLeagueDetail(id)

        argumentCaptor<View<Response?>>().apply {

            com.nhaarman.mockito_kotlin.verify(matchRepository)
                .get_detail_league(com.nhaarman.mockito_kotlin.eq(id), capture())
            firstValue.onDataLoaded(detailLeague)
        }

        Mockito.verify(view_detail_league).onShowLoading()
        Mockito.verify(view_detail_league).onDataLoaded(detailLeague)
        Mockito.verify(view_detail_league).onHideLoading()
    }


    //next_match
    @Test
    fun get_next_match() {

        val id = "4387"

        matchPresenter.get_next_match(id)

        argumentCaptor<View<ResponseMatch?>>().apply {

            com.nhaarman.mockito_kotlin.verify(matchRepository)
                .next_match(com.nhaarman.mockito_kotlin.eq(id), capture())
            firstValue.onDataLoaded(match)
        }

        Mockito.verify(view_match).onShowLoading()
        Mockito.verify(view_match).onDataLoaded(match)
        Mockito.verify(view_match).onHideLoading()
    }


    //prev_match
    @Test
    fun get_prev_match() {

        val id = "4387"

        matchPresenter.get_prev_match(id)

        argumentCaptor<View<ResponseMatch?>>().apply {

            com.nhaarman.mockito_kotlin.verify(matchRepository)
                .prev_match(com.nhaarman.mockito_kotlin.eq(id), capture())
            firstValue.onDataLoaded(match)
        }

        Mockito.verify(view_match).onShowLoading()
        Mockito.verify(view_match).onDataLoaded(match)
        Mockito.verify(view_match).onHideLoading()
    }

    //search_match
    @Test
    fun get_search_match() {

        val query = "chelsea"

        matchPresenter.get_search(query)

        argumentCaptor<View<ResponseSearchMatch?>>().apply {

            com.nhaarman.mockito_kotlin.verify(matchRepository)
                .get_search_match(com.nhaarman.mockito_kotlin.eq(query), capture())
            firstValue.onDataLoaded(search_match)
        }

        Mockito.verify(view_search).onShowLoading()
        Mockito.verify(view_search).onDataLoaded(search_match)
        Mockito.verify(view_search).onHideLoading()
    }



    //detail match
    @Test
    fun get_detail_match() {

        val id = "441613"

        matchPresenter.get_detail_match(id)

        argumentCaptor<View<ResponseDetailMatch?>>().apply {

            com.nhaarman.mockito_kotlin.verify(matchRepository)
                .get_detail_match(com.nhaarman.mockito_kotlin.eq(id), capture())
            firstValue.onDataLoaded(detail_match)
        }

        Mockito.verify(view_detail_match).onShowLoading()
        Mockito.verify(view_detail_match).onDataLoaded(detail_match)
        Mockito.verify(view_detail_match).onHideLoading()
    }
}