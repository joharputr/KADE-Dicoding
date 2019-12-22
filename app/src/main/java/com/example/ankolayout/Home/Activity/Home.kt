package com.example.ankolayout.Home.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.ankolayout.API.Pojo.Dummy.DataLeague
import com.example.ankolayout.Favorite.UI.Fragment.FavoriteFragment
import com.example.ankolayout.Favorite.UI.Fragment.FavoriteNextMatchFragment
import com.example.ankolayout.Home.Fragment.HomeFragment
import com.example.ankolayout.R
import kotlinx.android.synthetic.main.activity_main_home.*

class Home : AppCompatActivity() {

    val list = ArrayList<DataLeague>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_home)

        setFragment(HomeFragment(), "Home")
        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navHome -> setFragment(HomeFragment(), "League List")
                else -> setFragment(FavoriteFragment(), "Favorite")
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    fun setFragment(fragment: Fragment, title: String) {
        this.title = title
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }


}
