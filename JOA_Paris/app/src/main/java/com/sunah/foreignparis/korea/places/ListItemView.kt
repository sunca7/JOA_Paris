package com.sunah.foreignparis.korea.places

import android.content.Context
import android.text.Html
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

        orientation = HORIZONTAL

        var imageView: ImageView = findViewById(R.id.info_image)
        var textView: TextView = findViewById(R.id.info_string)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.ListItemView)
        imageView.setImageDrawable(attributes.getDrawable(R.styleable.ListItemView_image))
        textView.text = attributes.getString(R.styleable.ListItemView_text)

        attributes.recycle()

    }

    fun setHtmlInfo (iconResId: Int, text: String){
        info_image.setImageResource(iconResId)
        info_string.setText(Html.fromHtml(text))
    }

    fun setInfo(iconResId: Int, text: String) { // parcelable
        info_image.setImageResource(iconResId)
        info_string.text = text
    }
}