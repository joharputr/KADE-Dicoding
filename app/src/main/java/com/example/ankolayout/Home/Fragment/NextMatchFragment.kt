package com.example.ankolayout.Home.Fragment

import android.app.SearchManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ankolayout.API.Pojo.Match.EventsItemMatch
import com.example.ankolayout.API.Pojo.Match.ResponseMatch
import com.example.ankolayout.App
import com.example.ankolayout.Home.Activity.DetailMatch
import com.example.ankolayout.Home.Activity.SearchDetailMatch
import com.example.ankolayout.Home.Adapter.NextMatchAdapter
import com.example.ankolayout.R
import kotlinx.android.synthetic.main.next_match.*
import kotlinx.android.synthetic.main.previousmatch.progressPrev
import kotlinx.android.synthetic.main.previousmatch.recyclerPrev
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NextMatchFragment : Fragment() {
    var data = EventsItemMatch()
    private val list = ArrayList<EventsItemMatch>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.next_match, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        progress_next?.visibility = View.GONE
        initData()
        search()
    }

    private fun initData() {
        progress_next.visibility = View.VISIBLE
        App.api.get_next_match(App.preferenceHelper.id_league)
            .enqueue(object : Callback<ResponseMatch> {
                override fun onFailure(call: Call<ResponseMatch>, t: Throwable) {
               //     App.preferenceHelper.clearLeague()
                    progress_next?.visibility = View.GONE
                }

                override fun onResponse(
                    call: Call<ResponseMatch>, response: Response<ResponseMatch>
                ) {

                    Log.d("CEKDATAPREV", response.body()?.events.toString())
                    progress_next?.visibility = View.GONE
             //       App.preferenceHelper.clearLeague()

                    try {
                        for (i in 0 until response.body()?.events!!.size) {
                            val dataPrev = response.body()?.events!!.get(i)
                            val idEvent = dataPrev?.idEvent
                            val homeTeamName = dataPrev?.strHomeTeam
                            val AwayTeamName = dataPrev?.strAwayTeam
                            val scoreHome = dataPrev?.intHomeScore
                            val scoreAway = dataPrev?.intAwayScore
                            val strSport = dataPrev?.strSport
                            val idHome = dataPrev?.idHomeTeam
                            val idAway = dataPrev?.idAwayTeam

                            data = EventsItemMatch(
                                idEvent,
                                scoreHome,
                                scoreAway,
                                AwayTeamName,
                                homeTeamName,
                                strSport,
                                idHome,
                                idAway,
                                ""
                            )

                            Log.d("CEKDATAREcyclerNExt", data.toString())
                            list.addAll(listOf(data))
                            recyclerPrev.run {
                                layoutManager = LinearLayoutManager(context)
                                adapter = NextMatchAdapter(list) {
                                    click(it)
                                }
                            }
                        }
                    } catch (e: NullPointerException) {
                        Toast.makeText(context, "data kosong", Toast.LENGTH_SHORT).show()
                    }
                }
            })
    }

    private fun click(it: EventsItemMatch) {
        val intent = Intent(context, DetailMatch::class.java)
        intent.putExtra("detailmatch", it)
        startActivity(intent)
    }

    private fun search() {
        val searchManager = context?.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val componentName = ComponentName(context!!, SearchDetailMatch::class.java)
        searchViewNext.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchViewNext.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                Log.d("querysub =", query)

                return false
            }
        })

    }

}