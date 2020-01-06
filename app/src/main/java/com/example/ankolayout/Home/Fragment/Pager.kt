package com.example.ankolayout.Home.Fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class Pager(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val page = listOf(
        NextMatchFragment(),
        PreviousMatchFragment(),
        TeamFragment()

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
            1 -> "Prev Match"
            else -> "Team"
        }
    }
}