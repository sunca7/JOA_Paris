package com.sunah.foreignparis.korea.places

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.sunah.foreignparis.korea.R
import kotlinx.android.synthetic.main.list_item_view.view.*

class ListItemView(context: Context, attrs: AttributeSet): LinearLayout(context, attrs) {

    init {
        LayoutInflater.from(context).inflate(R.layout.list_item_view, this, true)

        orientation = HORIZONTAL  // linearlayout - horizontal

        var imageView: ImageView = findViewById(R.id.info_image)
        var textView: TextView = findViewById(R.id.info_name)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.ListItemView)
        imageView.setImageDrawable(attributes.getDrawable(R.styleable.ListItemView_image))
        textView.text = attributes.getString(R.styleable.ListItemView_text)
        attributes.recycle()

        setInfo((textView.text as String))
    }

    fun setInfo(text: String, iconResId: Int) { // parcelable
        info_name.text = text
        // info_image.setImageDrawable()
    }

}