package com.example.ankolayout.Home.Activity

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ankolayout.API.Pojo.Match.EventsItemMatch
import com.example.ankolayout.API.Pojo.Match.ResponseSearchMatch
import com.example.ankolayout.App
import com.example.ankolayout.Home.Adapter.MatchAdapter
import com.example.ankolayout.R
import kotlinx.android.synthetic.main.activity_search_detail_match.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchDetailMatch : AppCompatActivity() {
    private var search: String? = null
    val arraylist = ArrayList<EventsItemMatch>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_detail_match)
        progressSearch.visibility = View.GONE
        handleIntent(intent)
        Search()
        title = search
    }

    override fun onNewIntent(intent: Intent?) {
        handleIntent(intent!!)
    }

    private fun handleIntent(intent: Intent) {
        if (Intent.ACTION_SEARCH == intent.action) {
            search = intent.getStringExtra(SearchManager.QUERY)
            Log.d("SearchData= ", search)

        }
    }

    fun Search() {
        progressSearch.visibility = View.VISIBLE
        Log.d("SearchDataAPI= ", search)
        App.api.search_match(search).enqueue(object : Callback<ResponseSearchMatch> {
            override fun onFailure(call: Call<ResponseSearchMatch>, t: Throwable) {
                Log.d("CHEKDATASEARCH = ", t.toString())
                progressSearch.visibility = View.GONE
            }

            override fun onResponse(
                call: Call<ResponseSearchMatch>,
                response: Response<ResponseSearchMatch>
            ) {
                try {
                    progressSearch.visibility = View.GONE
                    val data = response.body()
                    Log.d("CHEKDATASEARCH = ", data.toString())
                    for (i in 0 until data?.events!!.size) {
                        val dataSearch = data.events.get(i)
                        val idEvent = dataSearch?.idEvent
                        val homeScore = dataSearch?.intHomeScore
                        val awayScore = dataSearch?.intAwayScore
                        val homeTeam = dataSearch?.strHomeTeam
                        val awayTeam = dataSearch?.strAwayTeam
                        val list =
                            EventsItemMatch(idEvent, homeScore, awayScore, awayTeam, homeTeam)
                        Log.d("CHEKLIST = ", list.toString())

                        arraylist.addAll(listOf(list))
                        RecyclerDetailSearch.run {
                            layoutManager = LinearLayoutManager(this@SearchDetailMatch)
                            adapter = MatchAdapter(arraylist) {
                                click(it)
                            }
                        }
                    }
                } catch (e: NullPointerException) {
                    Toast.makeText(this@SearchDetailMatch, "data kosong", Toast.LENGTH_SHORT).show()
                }
            }

        })

    }

    private fun click(it: EventsItemMatch) {
        val intent = Intent(this, DetailMatch::class.java)
        intent.putExtra("detailmatch", it)
        startActivity(intent)
    }
}
