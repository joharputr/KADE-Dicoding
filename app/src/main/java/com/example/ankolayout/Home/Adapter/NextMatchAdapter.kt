package com.example.ankolayout.Home.Adapter

import android.database.sqlite.SQLiteConstraintException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ankolayout.API.Pojo.Match.EventsItemMatch
import com.example.ankolayout.Favorite.AnkoSqlite.FavoriteData
import com.example.ankolayout.Favorite.AnkoSqlite.db
import com.example.ankolayout.Helper.Constant
import com.example.ankolayout.R
import kotlinx.android.synthetic.main.previous_match_list.view.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

class NextMatchAdapter(
    val list: ArrayList<EventsItemMatch>,
    val onClik: (eventsItemNext: EventsItemMatch) -> Unit
) :
    RecyclerView.Adapter<NextMatchAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var isFavorite: Boolean = false

        fun bind(item: EventsItemMatch) = itemView.apply {
            Glide.with(context).load(R.drawable.bola).into(gambarHome)
            Glide.with(context).load(R.drawable.bola).into(gambarAway)
            skorHome.text = item.intHomeScore
            skorAway.text = item.intAwayScore
            teamHome.text = item.strHomeTeam
            teamAway.text = item.strAwayTeam

            starEmpty.setOnClickListener {
                if (isFavorite) {
                    removeFromFav(item)
                    isFavorite = false
                } else {
                    addToFav(item)
                    isFavorite = true

                }
                setFavorite()

            }
        }

        fun favoriteState(event: EventsItemMatch) {
            itemView.context.db.use {
                val res = select(Constant.TABLE_FAV_NEXT)
                    .whereArgs(
                        "(EVENT_ID = {id})",
                        "id" to "${event.idEvent}"
                    )
                val favv = res.parseList(classParser<FavoriteData>())
                if (!favv.isEmpty()) {
                    isFavorite = true
                    setFavorite()
                }
            }
        }

        fun setFavorite() {
            if (isFavorite)
                itemView.starEmpty.setImageResource(R.drawable.ic_star_black_24dp)
            else
                itemView.starEmpty.setImageResource(R.drawable.star_empty)
        }

        fun addToFav(event: EventsItemMatch) {
            try {
                itemView.context!!.db.use {
                    insert(
                        Constant.TABLE_FAV_NEXT,
                        Constant.ID to event.idEvent,
                        Constant.EVENT_ID to event.idEvent,
                        Constant.HOME_TEAM_NAME to event.strHomeTeam,
                        Constant.AWAY_TEAM_NAME to event.strAwayTeam,
                        Constant.HOME_SCORE to event.intHomeScore,
                        Constant.AWAY_SCORE to event.intAwayScore
                    )
                }
                Toast.makeText(itemView.context, "Add to favorite", Toast.LENGTH_SHORT).show()
            } catch (e: SQLiteConstraintException) {
                Toast.makeText(itemView.context, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        fun removeFromFav(event: EventsItemMatch) {
            try {
                itemView.context.db.use {
                    delete(
                        Constant.TABLE_FAV_NEXT,
                        "(EVENT_ID = {id})",
                        "id" to "${event.idEvent}"
                    )
                }
                Toast.makeText(itemView.context, "Removes from favorite", Toast.LENGTH_SHORT).show()
            } catch (e: SQLiteConstraintException) {
                Toast.makeText(itemView.context, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NextMatchAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.previous_match_list,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NextMatchAdapter.ViewHolder, position: Int) {
        val item = list[position]
        holder.favoriteState(list[position])
        holder.bind(item)
        holder.itemView.setOnClickListener {
            onClik(item)
        }
    }


    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}