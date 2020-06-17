package com.example.ankolayout.Home.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ankolayout.API.Pojo.Dummy.DataLeague
import com.example.ankolayout.R
import kotlinx.android.synthetic.main.item_list.view.*

class LeagueAdapter(
    private val context: Context,
    private val list: ArrayList<DataLeague>,
    val clik: (DataLeague) -> Unit
) :
    RecyclerView.Adapter<LeagueAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: DataLeague) = itemView.run {
            titleLeague.text = item.title
            Glide.with(context).load(item.imageView).into(gambar)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)

        holder.itemView.setOnClickListener {
            clik(item)
        }


    }
}