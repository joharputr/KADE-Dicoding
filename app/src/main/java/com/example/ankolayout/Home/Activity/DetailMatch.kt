package com.example.ankolayout.Home.Activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.ankolayout.API.Pojo.DetailMatch.ResponseDetailMatch
import com.example.ankolayout.API.Pojo.DetailTeam.ResponseDetailTeam
import com.example.ankolayout.API.Pojo.Match.EventsItemMatch
import com.example.ankolayout.App
import com.example.ankolayout.R
import kotlinx.android.synthetic.main.activity_detail_match.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class DetailMatch : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)
        progressDetailMatch.visibility = View.GONE
        initData()
        val intent = intent
        val data = intent.getParcelableExtra<EventsItemMatch>("detailmatch")
        title = "${data.strHomeTeam} vs ${data.strAwayTeam}"
        initDataBadge()
    }

    private fun initDataBadge() {
        val intent = intent
        val data = intent.getParcelableExtra<EventsItemMatch>("detailmatch")
        App.api.get_detail_team(data.idHomeTeam)
            .enqueue(object : Callback<ResponseDetailTeam> {
                override fun onFailure(
                    call: Call<ResponseDetailTeam>,
                    t: Throwable
                ) {

                }

                override fun onResponse(
                    call: Call<ResponseDetailTeam>,
                    response: Response<ResponseDetailTeam>
                ) {

                    val databadge = response.body()?.events?.get(0)
                    Glide.with(applicationContext).load(databadge?.strTeamBadge).into(homeImage)

                }
            })


        App.api.get_detail_team(data.idAwayTeam)
            .enqueue(object : Callback<ResponseDetailTeam> {
                override fun onFailure(
                    call: Call<ResponseDetailTeam>,
                    t: Throwable
                ) {

                }

                override fun onResponse(
                    call: Call<ResponseDetailTeam>,
                    response: Response<ResponseDetailTeam>
                ) {

                    val databadgeAway =
                        response.body()?.events?.get(0)
                    Glide.with(applicationContext).load(databadgeAway?.strTeamBadge).into(awayImage)

                }
            })
    }


    private fun initData() {
        progressDetailMatch.visibility = View.VISIBLE
        val intent = intent
        val data = intent.getParcelableExtra<EventsItemMatch>("detailmatch")
        val id = data.idEvent
        App.api.get_detail_match(id).enqueue(object : Callback<ResponseDetailMatch> {
            override fun onFailure(call: Call<ResponseDetailMatch>, t: Throwable) {
                progressDetailMatch.visibility = View.GONE
            }

            override fun onResponse(
                call: Call<ResponseDetailMatch>,
                response: Response<ResponseDetailMatch>
            ) {
                progressDetailMatch.visibility = View.GONE
                val data = response.body()?.events?.get(0)
                teamHomeDetail.text = data?.strHomeTeam
                teamAwayDetail.text = data?.strAwayTeam
                homeScore.text = data?.intHomeScore
                awayScore.text = data?.intAwayScore
                homeShots.text = data?.intHomeShots
                homeFormation.text = data?.strHomeFormation
                awayFormation.text = data?.strAwayFormation
                homeRedcard.text = data?.strHomeRedCards
                awayRedcard.text = data?.strAwayRedCards
                homeYellowCard.text = data?.strHomeYellowCards
                awayYellowCard.text = data?.strAwayYellowCards
            }

        })
    }
}
