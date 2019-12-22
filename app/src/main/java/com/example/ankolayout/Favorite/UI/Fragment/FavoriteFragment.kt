package com.example.ankolayout.Favorite.UI.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ankolayout.R
import kotlinx.android.synthetic.main.fragment_favorite_.*

class FavoriteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite_, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewpager_main_favorite.adapter = PagerFavorite(childFragmentManager)
        tabs_main_favorite.setupWithViewPager(viewpager_main_favorite)
    }
}