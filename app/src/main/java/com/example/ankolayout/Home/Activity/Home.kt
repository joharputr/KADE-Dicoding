package com.example.ankolayout.Home.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ankolayout.API.Pojo.DetailLeague.Response
import com.example.ankolayout.API.Pojo.Dummy.DataLeague
import com.example.ankolayout.App
import com.example.ankolayout.Home.Adapter.LeagueAdapter
import com.example.ankolayout.R
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback

class Home : AppCompatActivity() {

    val list = ArrayList<DataLeague>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "League List"
        progBar.visibility = View.GONE
        list.add(
            DataLeague(
                4328,
                "English Premier League",
                "The Premier League (often referred to as the English Premier League (EPL) outside England), is the top level of the English football league system. Contested by 20 clubs, it operates on a system of promotion and relegation with the English Football League (EFL).",
                R.drawable.english, ""

            )
        )
        list.add(
            DataLeague(
                4334,
                " French Ligue 1",
                "Ligue 1 (French pronunciation: \u200B; League 1, formerly known as Division 1), is the French professional league for association football clubs. It is the country's primary football competition and serves as the top division of the French football league system. Ligue 1 is one of two divisions making up the Ligue de Football Professionnel, the other being Ligue 2. Contested by 20 clubs, it operates on a system of promotion and relegation with Ligue 2. Seasons run from August to May, with teams playing 38 games each totaling 380 games in the season. Most games are played on Saturdays and Sundays, with a few games played during weekday evenings. Play is regularly suspended the last weekend before Christmas for two weeks before returning in the second week of January. Ligue 1 is one of the top national leagues, currently ranked sixth in Europe behind the Spanish La Liga, English Premier League, the German Bundesliga, the Portuguese Primeira Liga and the Italian Serie A.",
                R.drawable.french, ""
            )
        )
        list.add(
            DataLeague(
                4331,
                "German Bundesliga",
                "The Fußball-Bundesliga (English: Football Federal League), commonly known as the Bundesliga, is a professional association football league in Germany and the football league with the highest average stadium attendance worldwide. At the top of the German football league system, the Bundesliga is Germany's primary football competition. The Bundesliga is contested by 18 teams and operates on a system of promotion and relegation with the 2. Bundesliga. Seasons run from August to May. Most games are played on Saturdays and Sundays, with a few games played during weekdays. All of the Bundesliga clubs qualify for the DFB-Pokal. The winner of the Bundesliga qualifies for the DFL-Supercup.\n",
                R.drawable.german, ""
            )
        )
        list.add(
            DataLeague(
                4332,
                "Italian Serie A",
                "Serie A, also called Serie A TIM due to sponsorship by Telecom Italia, is a professional league competition for football clubs located at the top of the Italian football league system and has been operating for over eighty years since the 1929–30 season. It had been organized by Lega Calcio until 2010, but a new league, the Lega Serie A, was created for the 2010–11 season. Serie A is regarded as one of the best football leagues in the world. Serie A was considered the best league in the world in the '90s, and has produced the highest number of European Cup finalists: Italian clubs have reached the final of the competition on a record twenty-six different occasions, winning the title twelve times. Serie A is ranked 4th among European leagues according to UEFA's league coefficient behind the Spanish La Liga, English Premier League and German Bundesliga, which is based on the performance of Italian clubs in the Champions League and the Europa League. It also ranked 5th in world according to the first trends of the 2011 IFFHS rating.",
                R.drawable.itali, ""
            )
        )
        list.add(
            DataLeague(
                4335,
                "Spanish La Liga",
                "The Primera División, commonly known as La Liga and as La Liga Santander for sponsorship reasons, is the top professional association football division of the Spanish football league system. Administrated by the Liga de Fútbol Profesional (LFP), La Liga is contested by 20 teams, with the three lowest-placed teams relegated to the Segunda División and replaced by the top two teams in that division plus the winner of a play-off.",
                R.drawable.spaon, ""
            )
        )
        list.add(
            DataLeague(
                4346,
                " American Mayor League",
                "Major League Soccer (MLS) is a professional soccer league representing the sport's highest level in both the United States and Canada. MLS constitutes one of the major professional sports leagues of the United States and Canada. The league is composed of 20 teams—17 in the U.S. and 3 in Canada. The MLS regular season runs from March to October, with each team playing 34 games; the team with the best record is awarded the Supporters' Shield. The post season includes twelve teams competing in the MLS Cup Playoffs through November and December, culminating in the championship game, the MLS Cup. MLS teams also play in other competitions against teams from other divisions and countries, such as the U.S. Open Cup, the Canadian Championship, and the CONCACAF Champions League. MLS is sanctioned by the United States Soccer Federation (U.S. Soccer).\n",
                R.drawable.amerika, ""
            )
        )
        list.add(
            DataLeague(
                4344,
                " Protugeuese Premiera Liga",
                "The Primeira Liga is contested by 18 clubs, but only five of them have won the title. Founded in 1934, the league is in its 81st edition (counting four experimental leagues in the 1930s). It has been dominated by the \"Big Three\": Benfica, Porto and Sporting CP. These three clubs have won a total of 78 titles, with \n" +
                        "Belenenses and Boavista winning the other two.\n",
                R.drawable.portugal, ""
            )
        )
        list.add(
            DataLeague(
                4356,
                " Australian A League",
                "The A-League is a professional men's soccer league, run by Football Federation Australia (FFA). At the top of the Australian league system, it is the country's primary competition for the sport. The A-League was established in 2004 as a successor to the National Soccer League (NSL) and competition commenced in August 2005. The league is currently contested by ten teams; nine based in Australia and one based in New Zealand. It is known as the Hyundai A-League (HAL) through a sponsorship arrangement with the Hyundai Motor Company.",
                R.drawable.australi, ""
            )
        )
        list.add(
            DataLeague(
                4330,
                " Scotish Premier League",
                "The Scottish Premiership is the top division of the Scottish Professional Football League, the league competition for professional football clubs in Scotland. The Scottish Premiership was established in July 2013, after the Scottish Professional Football League was formed by a merger of the Scottish Premier League and Scottish Football League. Teams receive three points for a win and one point for a draw. No points are awarded for a loss. Teams are ranked by total points, then goal difference, and then goals scored. At the end of each season, the club with the most points is crowned league champion. If points are equal, the goal difference and then goals scored determine the winner.\n",
                R.drawable.scot, ""
            )
        )
        list.add(
            DataLeague(
                4396,
                "English League 1",
                "Football League One (often referred to as League One for short or Sky Bet League 1) is the second-highest division of the Football League and the third tier in the English football league system.\n" +
                        "\n" +
                        "At present (2014–15 season), Oldham Athletic hold the longest tenure in League One, last being out of the division in the 1996–97 season when they were relegated from the Championship. There are currently six former Premier League clubs competing in the League One, namely Barnsley, Bradford City, Coventry City, Oldham Athletic, Sheffield United and Swindon Town.\n",
                R.drawable.english2, ""
            )
        )
        Log.d("Listdata", "sdsdsd")
        Log.d("Listdata", list.toString())
        recyclerview.run {
            layoutManager = GridLayoutManager(context, 2)
            adapter =
                LeagueAdapter(
                    context,
                    list
                ) {
                    click(it)
                }
        }

    }

    private fun click(dataClass: DataLeague) {
        progBar.visibility = View.VISIBLE
        App.preferenceHelper.id_team = dataClass.id.toString()
        Log.d("CheckDataId = ", App.preferenceHelper.id_team)
        App.api.get_detail_league(dataClass.id.toString()).enqueue(object : Callback<Response> {

            override fun onFailure(call: Call<Response>, t: Throwable) {
                progBar.visibility = View.GONE
                Toast.makeText(this@Home, t.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<Response>,
                response: retrofit2.Response<Response>
            ) {
                progBar.visibility = View.GONE
                val body = response.body()
                Log.d("CekData = ", body.toString())

                val id = body?.leagues?.get(0)?.idLeague
                val gambar = body?.leagues?.get(0)?.strFanart1
                val title = body?.leagues?.get(0)?.strLeague
                val desc = body?.leagues?.get(0)?.strDescriptionEN
                val list =
                    DataLeague(
                        id!!.toInt(),
                        title.toString(),
                        desc.toString(),
                        0,
                        gambar.toString()
                    )
                val arraylist = ArrayList<DataLeague>()
                arraylist.addAll(listOf(list))
                Log.d("cekId = ", id)
                val intent = Intent(this@Home, Detail::class.java)
                intent.putExtra("detail", list)
                startActivity(intent)
            }
        })
    }
}
