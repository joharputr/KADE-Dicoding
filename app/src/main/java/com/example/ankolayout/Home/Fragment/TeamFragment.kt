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
import com.example.ankolayout.API.Pojo.DaftarTeam.Response_dft_team
import com.example.ankolayout.API.Pojo.DaftarTeam.TeamsItem
import com.example.ankolayout.App
import com.example.ankolayout.Home.Activity.DetailTeam
import com.example.ankolayout.Home.Activity.SearchDetailTeam
import com.example.ankolayout.Home.Adapter.SearchTeamAdapter
import com.example.ankolayout.Home.Adapter.TeamAdapter
import com.example.ankolayout.R
import kotlinx.android.synthetic.main.team_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamFragment : Fragment() {
    val list = ArrayList<TeamsItem>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.team_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        progress_team_list.visibility = View.GONE
        initData()
        search()
    }

    private fun initData() {
        progress_team_list.visibility = View.VISIBLE
        App.api.get_team_list(App.preferenceHelper.id_league)
            .enqueue(object : Callback<Response_dft_team> {
                override fun onFailure(call: Call<Response_dft_team>, t: Throwable) {
                    Toast.makeText(context, t.localizedMessage, Toast.LENGTH_SHORT).show()
                    Log.d("TESTDATAGAGAL = ", t.localizedMessage)
                    //    App.preferenceHelper.clearLeague()
                    progress_team_list?.visibility = View.GONE
                }

                override fun onResponse(
                    call: Call<Response_dft_team>,
                    response: Response<Response_dft_team>
                ) {
                    //  App.preferenceHelper.clearLeague()
                    progress_team_list?.visibility = View.GONE
                    for (i in 0 until response.body()?.teams?.size!!) {
                        val data = response.body()?.teams!![i]
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
                        val item = TeamsItem(
                            id,
                            nickname,
                            year,
                            stadium,
                            img,
                            website,
                            nama,
                            desc,
                            strSport
                        )
                        list.addAll(listOf(item))
                        recycler_team_list.run {
                            adapter = TeamAdapter(list) {
                                click(it)
                            }
                            layoutManager = LinearLayoutManager(context)
                        }
                    }
                }
            })
    }

    private fun click(it: TeamsItem) {
        val intent = Intent(context, DetailTeam::class.java)
        intent.putExtra("team", it)
        startActivity(intent)
    }

    private fun search() {
        val searchManager = context?.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val componentName = ComponentName(context!!, SearchDetailTeam::class.java)
        searchView_team.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView_team.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
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