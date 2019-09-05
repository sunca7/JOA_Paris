package com.sunah.foreignparis.korea

import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.home_list.view.*

class HomeAdapter(var categories: MutableList<CategoryInfo>): RecyclerView.Adapter<CategoryViewHolder>(){


    override fun getItemCount() = categories.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
       holder.bind(categories[position])
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        return CategoryViewHolder(inflater, parent)
    }

}

class CategoryViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.home_list, parent, false)){
    private var mNamesView: TextView? = null

    init {
        mNamesView= itemView.findViewById(R.id.tv_category_list)
    }

    fun bind(categoryInfo: CategoryInfo){
        mNamesView?.text = categoryInfo.name["en"]
    }
}