package com.example.ankolayout.Home.Adapter


import android.database.sqlite.SQLiteConstraintException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ankolayout.API.Pojo.DaftarTeam.TeamsItem
import com.example.ankolayout.Favorite.AnkoSqlite.FavoriteTeam
import com.example.ankolayout.Favorite.AnkoSqlite.db
import com.example.ankolayout.Helper.Constant
import com.example.ankolayout.R
import kotlinx.android.synthetic.main.team_list_adapter.view.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select


class TeamAdapter(
    val list: ArrayList<TeamsItem>,
    val onClik: (eventsItemNext: TeamsItem) -> Unit
) :
    RecyclerView.Adapter<TeamAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var isFavorite: Boolean = false

        fun bind(item: TeamsItem) = itemView.apply {
            Glide.with(context).load(item.strTeamBadge).into(image_team)
            name_team.text = item.strTeam
            desc_team.text = item.strDescriptionEN

            starEmptyteam.setOnClickListener {
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

        fun favoriteState(event: TeamsItem) {
            itemView.context.db.use {
                val res = select(Constant.TABLE_FAV_TEAM)
                    .whereArgs(
                        "(EVENT_ID = {id})",
                        "id" to "${event.idTeam}"
                    )
                val favv = res.parseList(classParser<FavoriteTeam>())
                if (!favv.isEmpty()) {
                    isFavorite = true
                    setFavorite()
                }
            }
        }

        fun setFavorite() {
            if (isFavorite)
                itemView.starEmptyteam.setImageResource(R.drawable.ic_star_black_24dp)
            else
                itemView.starEmptyteam.setImageResource(R.drawable.star_empty)
        }

        fun addToFav(event: TeamsItem) {
            try {
                itemView.context!!.db.use {
                    insert(
                        Constant.TABLE_FAV_TEAM,
                        Constant.ID to event.idTeam,
                        Constant.EVENT_ID to event.idTeam,
                        Constant.TEAM_NAME to event.strTeam,
                        Constant.TEAM_DESC to event.strDescriptionEN,
                        Constant.TEAM_IMG to event.strTeamBadge
                    )
                }
                Toast.makeText(itemView.context, "Add to favorite", Toast.LENGTH_SHORT).show()
            } catch (e: SQLiteConstraintException) {
                Toast.makeText(itemView.context, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        fun removeFromFav(event: TeamsItem) {
            try {
                itemView.context.db.use {
                    delete(
                        Constant.TABLE_FAV_TEAM,
                        "(EVENT_ID = {id})",
                        "id" to "${event.idTeam}"
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