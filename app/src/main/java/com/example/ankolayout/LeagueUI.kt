package com.example.ankolayout

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.marginLeft
import org.jetbrains.anko.*


class LeagueUI : AnkoComponent<ViewGroup> {

    companion object {
        val title = 1
        val deskripsi = 2
        val imagesss = 3
    }

    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
        verticalLayout {
            lparams(matchParent, wrapContent)
            padding = dip(16)
            imageView {
                id = imagesss
                setImageResource(R.drawable.ic_launcher_background)
                layoutParams = LinearLayout.LayoutParams(100, 100)
            }
            textView {
                id = title
                layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent)
                text = "Sherlock"
                textSize = 16f // <- it is sp, no worries
                textColor = Color.BLACK
            }

            textView {
                visibility = View.GONE
                id = deskripsi
                layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent)
                text = "2009"
                textSize = 14f
            }


        }
    }
}