package com.example.ankolayout

import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import org.jetbrains.anko.*


class Detail : AppCompatActivity() {


    private var team_name: String = ""
    private var team_image: Int = 0
    private var team_description: String = ""

    lateinit var name: TextView
    lateinit var images: ImageView
    lateinit var description: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            padding = dip(18)

            images = imageView()
                .lparams(
                    width = dip(100),
                    height = wrapContent
                ) {
                    gravity = Gravity.CENTER
                }

            name = textView()
                .lparams(width = wrapContent) {
                    gravity = Gravity.CENTER
                    topMargin = dip(12)
                }


            description = textView()
                .lparams(width = wrapContent) {
                    margin = dip(20)

                }
        }
        val intent = intent
        team_name = intent.getStringExtra("title")
        team_image = intent.getIntExtra("image", 0)
        team_description = intent.getStringExtra("desc")

        name.text = team_name
        Glide.with(images).load(team_image).into(images)
        description.text = team_description
    }
}
