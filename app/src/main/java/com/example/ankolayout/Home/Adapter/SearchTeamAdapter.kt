package com.example.ankolayout.Home.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ankolayout.API.Pojo.DaftarTeam.TeamsItem
import com.example.ankolayout.R
import kotlinx.android.synthetic.main.team_list_adapter.view.*

class SearchTeamAdapter(
    val list: ArrayList<TeamsItem>,
    val onClik: (eventsItemNext: TeamsItem) -> Unit
) :
    RecyclerView.Adapter<SearchTeamAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var isFavorite: Boolean = false

        fun bind(item: TeamsItem) = itemView.apply {
            Glide.with(context).load(item.strTeamBadge).into(image_team)
            name_team.text = item.strTeam
            desc_team.text = item.strDescriptionEN
            starEmptyteam.visibility = View.GONE
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.team_list_adapter,
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