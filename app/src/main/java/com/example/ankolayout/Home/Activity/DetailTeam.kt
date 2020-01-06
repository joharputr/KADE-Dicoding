package com.example.ankolayout.Home.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.ankolayout.API.Pojo.DaftarTeam.TeamsItem
import com.example.ankolayout.R
import kotlinx.android.synthetic.main.activity_detail_team.*

class DetailTeam : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_team)
        initIntent()
    }


    private fun initIntent() {
        val intent = getIntent()
        val data = intent.getParcelableExtra<TeamsItem>("team")
        title = data.strTeam
        Glide.with(this).load(data.strTeamBadge).into(image_team_detail)
        name_detail_team.text = data.strTeam
        year_detail_team.text = data.intFormedYear
        nickname_detail_team.text = data.strAlternate
        stadium_detail_team.text = data.strStadium
        website_detail_team.text = data.strWebsite


    }
}
