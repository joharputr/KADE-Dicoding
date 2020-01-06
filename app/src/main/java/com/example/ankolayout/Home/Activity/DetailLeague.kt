package com.example.ankolayout.Home.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.ankolayout.API.Pojo.Dummy.DataLeague
import com.example.ankolayout.API.Pojo.Klasemen.Response_Kelasemen
import com.example.ankolayout.API.Pojo.Klasemen.TableItem_klasemen
import com.example.ankolayout.App
import com.example.ankolayout.Home.Fragment.Pager
import com.example.ankolayout.Home.Adapter.KlasemenAdapter
import com.example.ankolayout.R
import kotlinx.android.synthetic.main.activity_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailLeague : AppCompatActivity() {

    val list = ArrayList<TableItem_klasemen>()

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

        initKelasemen(data.id.toString())
    }

    private fun initKelasemen(id_league: String) {
        App.api.get_kelasemen_table(id_league).enqueue(object : Callback<Response_Kelasemen> {
            override fun onFailure(call: Call<Response_Kelasemen>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<Response_Kelasemen>,
                response: Response<Response_Kelasemen>
            ) {

                for (i in 0 until response.body()?.table?.size!!) {
                    val data = response.body()?.table?.get(i)
                    val id = data?.teamid
                    val nama = data?.name
                    val played = data?.played
                    val win = data?.win
                    val draw = data?.draw
                    val lost = data?.loss
                    val total = data?.total

                    val Data_item = TableItem_klasemen(id, nama, played, win, lost, draw, total)
                    list.addAll(listOf(Data_item))
                    dft_team_rec.run {
                        adapter =
                            KlasemenAdapter(
                                list
                            )
                        layoutManager = LinearLayoutManager(this@DetailLeague)
                    }
                }

            }

        })

    }
}
