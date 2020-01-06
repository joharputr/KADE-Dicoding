package com.example.ankolayout.Home.Activity

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ankolayout.API.Pojo.DaftarTeam.Response_dft_team
import com.example.ankolayout.API.Pojo.DaftarTeam.TeamsItem
import com.example.ankolayout.App
import com.example.ankolayout.Home.Adapter.SearchTeamAdapter
import com.example.ankolayout.R
import kotlinx.android.synthetic.main.activity_search_detail_team.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchDetailTeam : AppCompatActivity() {
    private var search_team: String? = null
    val list = ArrayList<TeamsItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_detail_team)
        handleIntent(intent)
        title = search_team
        initData()
    }

    override fun onNewIntent(intent: Intent?) {
        handleIntent(intent!!)
    }

    private fun handleIntent(intent: Intent) {
        if (Intent.ACTION_SEARCH == intent.action) {
            search_team = intent.getStringExtra(SearchManager.QUERY)
            Log.d("SearchData= ", search_team)
        }
    }

    private fun initData() {
        prgrs_cari_team.visibility = View.VISIBLE
        App.api.search_team(search_team).enqueue(object : Callback<Response_dft_team> {
            override fun onFailure(call: Call<Response_dft_team>, t: Throwable) {
                Log.d("GAGAL", t.localizedMessage)
                prgrs_cari_team.visibility = View.GONE
            }

            override fun onResponse(
                call: Call<Response_dft_team>,
                response: Response<Response_dft_team>
            ) {
                prgrs_cari_team.visibility = View.GONE
                try {
                    for (i in 0 until response.body()?.teams?.size!!) {
                        val data = response.body()!!.teams!![i]
                        val id = data?.idTeam
                        val nama = data?.strTeam
                        val desc = data?.strDescriptionEN
                        val img = data?.strTeamBadge
                        val nickname = data?.strAlternate
                        val year = data?.intFormedYear
                        val stadium = data?.strStadium
                        val website = data?.strWebsite
                        val strSport = data?.strSport
                        Log.d("TESTDATA = ", data.toString())
                        val item = TeamsItem(id, nickname, year, stadium, img, website, nama, desc)
                        if (strSport == "Soccer"){
                            list.addAll(listOf(item))
                            cari_team_rec.run {
                                adapter = SearchTeamAdapter(list) {
                                    click(it)
                                }
                                layoutManager = LinearLayoutManager(context)
                            }
                        }
                    }
                } catch (e: NullPointerException) {
                    Toast.makeText(this@SearchDetailTeam, "data kosong", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun click(it: TeamsItem) {
        val intent = Intent(this, DetailTeam::class.java)
        intent.putExtra("team", it)
        startActivity(intent)
    }


}
