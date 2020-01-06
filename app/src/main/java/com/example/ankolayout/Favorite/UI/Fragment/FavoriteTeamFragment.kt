package com.example.ankolayout.Favorite.UI.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ankolayout.Favorite.Adapter.FavoriteAdapterNext
import com.example.ankolayout.Favorite.Adapter.FavoriteAdapterTeam
import com.example.ankolayout.Favorite.AnkoSqlite.FavoriteData
import com.example.ankolayout.Favorite.AnkoSqlite.FavoriteTeam
import com.example.ankolayout.Favorite.AnkoSqlite.db
import com.example.ankolayout.Helper.Constant
import com.example.ankolayout.R
import kotlinx.android.synthetic.main.fragment_favorite.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.support.v4.onRefresh

class FavoriteTeamFragment : Fragment() {
    private var fav_team = ArrayList<FavoriteTeam>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        showFav()

        swipeFavoriteFragment.onRefresh {
            fav_team.clear()
            showFav()
        }
    }

    private fun showFav() {
        context?.db?.use {
            fav_team.clear()
            swipeFavoriteFragment.isRefreshing = false
            val res = select(Constant.TABLE_FAV_TEAM)
            val favv = res.parseList(classParser<FavoriteTeam>())
            fav_team.addAll(favv)
            Log.d("favoriteNext = ", fav_team.toString())
            recyclerViewFavoriteFragment.run {
                layoutManager = LinearLayoutManager(context)
                adapter = FavoriteAdapterTeam(fav_team) {
                    click(it)
                }
            }
        }
    }

    private fun click(it: FavoriteTeam) {

    }
}