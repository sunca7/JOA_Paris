package com.sunah.foreignparis.korea

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.home_list.view.*

class HomeAdapter(var categories: MutableList<CategoryInfo>): RecyclerView.Adapter<CategoryViewHolder>(){


    override fun getItemCount() = categories.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
       holder.bind(categories[position])
       // holder.itemView.setOnClickListener() {
      //      Toast.makeText(MainA,categories[position].type, Toast.LENGTH_SHORT)
       // }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        return CategoryViewHolder(inflater, parent)
    }
}

class CategoryViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.home_list, parent, false)){
    private var mNamesView: TextView? = null
    private var mImagesView: ImageView? = null

    init {
        mNamesView= itemView.findViewById(R.id.tv_category_list)
        mImagesView= itemView.findViewById(R.id.iv_category)
    }

    fun bind(categoryInfo: CategoryInfo){
        mNamesView?.text = categoryInfo.name["en"]
        mImagesView?.let {
            Glide.with(itemView.context)
            .load(categoryInfo.picture)
            .centerCrop()
            .into(it)
        }

    }
}