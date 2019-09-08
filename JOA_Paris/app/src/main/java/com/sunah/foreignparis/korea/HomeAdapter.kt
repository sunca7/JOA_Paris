package com.sunah.foreignparis.korea

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class HomeAdapter(var categoryModels: List<CategoryInfoModel>) :
    RecyclerView.Adapter<CategoryViewHolder>() {


    override fun getItemCount() = categoryModels.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categoryModels[position])
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CategoryViewHolder(inflater, parent)
    }
}

class CategoryViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.home_list, parent, false)) {
    private var namesView: TextView? = null
    private var imagesView: ImageView? = null

    init {
        namesView = itemView.findViewById(R.id.tv_category_list)
        imagesView = itemView.findViewById(R.id.iv_category)
    }

    fun bind(categoryInfoModel: CategoryInfoModel) {
        namesView?.text = categoryInfoModel.name["en"]
        imagesView?.let {
            Glide.with(itemView.context)
                .load(categoryInfoModel.picture)
                .centerCrop()
                .into(it)
        }
        imagesView?.setOnClickListener() {
            Toast.makeText(imagesView?.context, categoryInfoModel.type, Toast.LENGTH_SHORT).show()
        }
    }
}