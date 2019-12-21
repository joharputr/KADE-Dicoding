package com.example.ankolayout.Home.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ankolayout.API.Pojo.Match.EventsItemMatch
import com.example.ankolayout.R
import kotlinx.android.synthetic.main.previous_match_list.view.*

class MatchAdapter(
    val list: ArrayList<EventsItemMatch>,
    val onClik: (eventsItemNext: EventsItemMatch) -> Unit
) :
    RecyclerView.Adapter<MatchAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: EventsItemMatch) = itemView.apply {
            Glide.with(context).load(R.drawable.bola).into(gambarHome)
            Glide.with(context).load(R.drawable.bola).into(gambarAway)
            skorHome.text = item.intHomeScore
            skorAway.text = item.intAwayScore
            teamHome.text = item.strHomeTeam
            teamAway.text = item.strAwayTeam
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MatchAdapter.ViewHolder {
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

    override fun onBindViewHolder(holder: MatchAdapter.ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            onClik(item)
        }
    }
}