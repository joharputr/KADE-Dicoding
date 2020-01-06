package com.example.ankolayout.Favorite.UI.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ankolayout.Favorite.Adapter.FavoriteAdapterNext
import com.example.ankolayout.Favorite.Adapter.FavoriteAdapterPrev
import com.example.ankolayout.Favorite.AnkoSqlite.FavoriteData
import com.example.ankolayout.Favorite.AnkoSqlite.db
import com.example.ankolayout.Helper.Constant
import com.example.ankolayout.R
import kotlinx.android.synthetic.main.fragment_favorite.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.support.v4.onRefresh

class FavoritePreviousMatchFragment : Fragment() {
    private var fav = ArrayList<FavoriteData>()
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
            fav.clear()
            showFav()
        }
    }

    private fun showFav() {
        fav.clear()
        context?.db?.use {
            swipeFavoriteFragment.isRefreshing = false
            val res = select(Constant.TABLE_FAV_PREV)
            val favv = res.parseList(classParser<FavoriteData>())
            fav.addAll(favv)
            recyclerViewFavoriteFragment.run {
                layoutManager = LinearLayoutManager(context)
                adapter = FavoriteAdapterPrev(fav) {
                    click(it)
                }
            }
        }
    }

    private fun click(it: FavoriteData) {

    }
}