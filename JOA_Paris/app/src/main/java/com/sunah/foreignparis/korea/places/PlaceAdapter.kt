package com.sunah.foreignparis.korea.places

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sunah.foreignparis.korea.R
import com.sunah.foreignparis.korea.places.model.PlaceInfoModel


class PlaceAdapter (var placeModels: List<PlaceInfoModel>) :
    RecyclerView.Adapter<PlaceViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PlaceViewHolder(inflater, parent)
    }

    override fun getItemCount() = placeModels.size

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        holder.bind(placeModels[position])

        holder.itemView.setOnClickListener {

            val bundle = Bundle()
            val parcel = placeModels[position]
            bundle.putParcelable("Details", parcel)
            it.findNavController().navigate(R.id.action_placeFragment_to_placeDetailFragment, bundle)
        }
    }
}

class PlaceViewHolder (inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.fragment_place_list, parent, false)) {
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