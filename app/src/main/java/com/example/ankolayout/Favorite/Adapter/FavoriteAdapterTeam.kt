package com.example.ankolayout.Favorite.Adapter

import android.database.sqlite.SQLiteConstraintException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ankolayout.Favorite.AnkoSqlite.FavoriteTeam
import com.example.ankolayout.Favorite.AnkoSqlite.db
import com.example.ankolayout.Helper.Constant
import com.example.ankolayout.R
import kotlinx.android.synthetic.main.team_list_favorite_adapter.view.*
import org.jetbrains.anko.db.delete

class FavoriteAdapterTeam(
    val list: ArrayList<FavoriteTeam>,
    val onClik: (eventsItemNext: FavoriteTeam) -> Unit
) :
    RecyclerView.Adapter<FavoriteAdapterTeam.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        fun bind(item: FavoriteTeam) = itemView.apply {
            Glide.with(context).load(item.imgTeam).into(image_team_fav)
            name_team_fav.text = item.nameTeam
            desc_team_fav.text = item.descTeam

            starBorderteam_fav.setOnClickListener {
                removeFromFav(item)
                starBorderteam_fav.visibility = View.GONE
                starEmptyfav_team.visibility = View.VISIBLE
            }
        }


        fun removeFromFav(event: FavoriteTeam) {
            try {
                itemView.context.db.use {
                    delete(
                        Constant.TABLE_FAV_TEAM,
                        "(EVENT_ID = {id})",
                        "id" to "${event.id}"
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
                R.layout.team_list_favorite_adapter,
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