package com.example.ankolayout.Home.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ankolayout.API.Pojo.Klasemen.TableItem_klasemen
import com.example.ankolayout.R
import kotlinx.android.synthetic.main.kelasemen.view.*

class KlasemenAdapter(
    val list: ArrayList<TableItem_klasemen>
) :
    RecyclerView.Adapter<KlasemenAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: TableItem_klasemen) {
            itemView.run {
                name.text = item.name
                played.text = item.played.toString()
                win.text = item.win.toString()
                lost.text = item.loss.toString()
                draw.text = item.draw.toString()
                total.text = item.total.toString()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.kelasemen,
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

    }
}



