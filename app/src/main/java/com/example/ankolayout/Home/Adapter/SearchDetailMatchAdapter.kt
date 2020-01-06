package com.example.ankolayout.Home.Adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ankolayout.API.Pojo.Match.EventsItemMatch
import com.example.ankolayout.R
import kotlinx.android.synthetic.main.previous_match_list.view.*


class SearchDetailMatchAdapter(
    val list: ArrayList<EventsItemMatch>,
    val onClik: (eventsItemNext: EventsItemMatch) -> Unit
) :
    RecyclerView.Adapter<SearchDetailMatchAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var isFavorite: Boolean = false

        fun bind(item: EventsItemMatch) = itemView.apply {
            Glide.with(context).load(R.drawable.bola).into(gambarHome)
            Glide.with(context).load(R.drawable.bola).into(gambarAway)
            skorHome.text = item.intHomeScore
            skorAway.text = item.intAwayScore
            teamHome.text = item.strHomeTeam
            teamAway.text = item.strAwayTeam
            starEmpty.visibility = View.GONE
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
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