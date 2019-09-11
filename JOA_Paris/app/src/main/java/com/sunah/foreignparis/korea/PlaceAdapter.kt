package com.sunah.foreignparis.korea

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PlaceAdapter (var placeModels: List<PlaceInfoModel>) :
    RecyclerView.Adapter<PlaceViewHolder>(){
    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        holder.bind(placeModels[position])
    }

    override fun getItemCount() = placeModels.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PlaceViewHolder(inflater, parent)
    }

}

class PlaceViewHolder (inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.resto_list, parent, false)) {
    private var namesView: TextView? = null
    private var imagesView: ImageView? = null

    init {
        namesView = itemView.findViewById(R.id.tv_place_list)
        imagesView = itemView.findViewById(R.id.iv_place)
    }

    fun bind(placeInfoModel: PlaceInfoModel) {
        namesView?.text = placeInfoModel.name["en"]
        imagesView?.let {
            Glide.with(itemView.context)
                .load(placeInfoModel.picture)
                .centerCrop()
                .into(it)
        }
    }
}