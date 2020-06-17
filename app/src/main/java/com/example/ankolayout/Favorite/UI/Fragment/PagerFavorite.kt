package com.example.ankolayout.Favorite.UI.Fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.ankolayout.Home.Fragment.NextMatchFragment
import com.example.ankolayout.Home.Fragment.PreviousMatchFragment

class PagerFavorite(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val page = listOf(
        FavoriteNextMatchFragment(),
        FavoritePreviousMatchFragment()
    )

    override fun getItem(position: Int): Fragment {
        return page[position]
    }

    override fun getCount(): Int {
        return page.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Next Match"
            else -> "Previous Match"
        }
    }
}