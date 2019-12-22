package com.example.ankolayout.Favorite.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ankolayout.Favorite.AnkoSqlite.FavoriteData
import com.example.ankolayout.R
import kotlinx.android.synthetic.main.previous_match_list.view.*

class FavoriteAdapter(
    val list: ArrayList<FavoriteData>,
    val onClik: (eventsItemNext: FavoriteData) -> Unit
) :
    RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(item: FavoriteData) = itemView.apply {
            Glide.with(context).load(R.drawable.bola).into(gambarHome)
            Glide.with(context).load(R.drawable.bola).into(gambarAway)
            skorHome.text = item.homeScore
            skorAway.text = item.awayScore
            teamHome.text = item.homeTeam
            teamAway.text = item.awayTeam
            starEmpty.visibility = View.GONE
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteAdapter.ViewHolder {
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

    override fun onBindViewHolder(holder: FavoriteAdapter.ViewHolder, position: Int) {
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