package com.sunah.foreignparis.korea.places

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.sunah.foreignparis.korea.R
import kotlinx.android.synthetic.main.list_item_view.view.*
import kotlinx.android.synthetic.main.using_custom_item_view.view.*
import kotlinx.android.synthetic.main.list_item_view.view.info_place as info_place1

class ListItemView(context: Context, attrs: AttributeSet): LinearLayout(context, attrs) {

    init {
        LayoutInflater.from(context).inflate(R.layout.list_item_view, this, true)

        val imageView: ImageView = findViewById(R.id.image)
        val textView: TextView = findViewById(R.id.info_place)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.ListItemView)
        imageView.setImageDrawable(attributes.getDrawable(R.styleable.ListItemView_image))
        textView.text = attributes.getString(R.styleable.ListItemView_text)
        attributes.recycle()
    }

    private fun setText(text: String) {
        info_place1 = text
    }
}