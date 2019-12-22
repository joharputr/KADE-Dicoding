package com.example.ankolayout.Home.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.ankolayout.API.Pojo.Dummy.DataLeague
import com.example.ankolayout.Home.Fragment.Pager
import com.example.ankolayout.R
import kotlinx.android.synthetic.main.activity_detail.*


class DetailLeague : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail)
        viewpager_main.adapter = Pager(supportFragmentManager)
        tabs_main.setupWithViewPager(viewpager_main)
        val intent = intent
        val data = intent.getParcelableExtra<DataLeague>("detail")
        title = data.title
        Glide.with(this).load(data.gambar).into(imageView)
        descDetail.text = data.description
        titleDetail.text = data.title
    }
}
