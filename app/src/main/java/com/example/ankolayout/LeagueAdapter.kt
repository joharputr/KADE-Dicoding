package com.example.ankolayout

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ankolayout.LeagueUI.Companion.title
import kotlinx.android.synthetic.main.item_list.view.*
import org.jetbrains.anko.AnkoContext

class LeagueAdapter(
    private val context: Context,
    private val list: ArrayList<dataClass>,
    val clik: (dataClass) -> Unit
) :
    RecyclerView.Adapter<LeagueAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: dataClass) {
            itemView.title.text = item.title
        //    description.text = item.description
            Glide.with(itemView)
                .load(item.imageView)
                .into(itemView.gambar)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      return  ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))
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