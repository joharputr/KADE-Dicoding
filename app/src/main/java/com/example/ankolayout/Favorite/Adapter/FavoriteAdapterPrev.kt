package com.example.ankolayout.Favorite.Adapter

import android.database.sqlite.SQLiteConstraintException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ankolayout.Favorite.AnkoSqlite.FavoriteData
import com.example.ankolayout.Favorite.AnkoSqlite.db
import com.example.ankolayout.Helper.Constant
import com.example.ankolayout.R
import kotlinx.android.synthetic.main.previous_match_fav.view.*
import kotlinx.android.synthetic.main.previous_match_list.view.gambarAway
import kotlinx.android.synthetic.main.previous_match_list.view.gambarHome
import kotlinx.android.synthetic.main.previous_match_list.view.skorAway
import kotlinx.android.synthetic.main.previous_match_list.view.skorHome
import kotlinx.android.synthetic.main.previous_match_list.view.teamAway
import kotlinx.android.synthetic.main.previous_match_list.view.teamHome
import org.jetbrains.anko.db.delete

class FavoriteAdapterPrev(
    val list: ArrayList<FavoriteData>,
    val onClik: (eventsItemNext: FavoriteData) -> Unit
) :
    RecyclerView.Adapter<FavoriteAdapterPrev.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //   private var isFavorite: Boolean = false
        fun bind(item: FavoriteData) = itemView.apply {
            Glide.with(context).load(R.drawable.bola).into(gambarHome)
            Glide.with(context).load(R.drawable.bola).into(gambarAway)
            skorHome.text = item.homeScore
            skorAway.text = item.awayScore
            teamHome.text = item.homeTeam
            teamAway.text = item.awayTeam

            starBorderfav.setOnClickListener {
                removeFromFav(item)
                starBorderfav.visibility = View.GONE
                starEmptyfav.visibility = View.VISIBLE
            }
        }


        fun removeFromFav(event: FavoriteData) {
            try {
                itemView.context.db.use {
                    delete(
                        Constant.TABLE_FAV_PREV,
                        "(EVENT_ID = {id})",
                        "id" to event.idEvent
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
    ): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.previous_match_fav,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
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