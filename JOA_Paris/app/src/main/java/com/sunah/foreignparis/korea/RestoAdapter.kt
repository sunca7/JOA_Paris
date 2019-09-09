package com.sunah.foreignparis.korea

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RestoAdapter (var restoModels: List<RestoInfoModel>) :
    RecyclerView.Adapter<RestoViewHolder>(){
    override fun onBindViewHolder(holder: RestoViewHolder, position: Int) {
        holder.bind(restoModels[position])
    }

    override fun getItemCount() = restoModels.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return RestoViewHolder(inflater, parent)
    }

}

class RestoViewHolder (inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.resto_list, parent, false)) {
    private var namesView: TextView? = null
    private var imagesView: ImageView? = null

    init {
        namesView = itemView.findViewById(R.id.tv_resto_list)
        imagesView = itemView.findViewById(R.id.iv_resto)
    }

    fun bind(restoInfoModel: RestoInfoModel) {
        namesView?.text = restoInfoModel.name["en"]
        imagesView?.let {
            Glide.with(itemView.context)
                .load(restoInfoModel.picture)
                .centerCrop()
                .into(it)
        }
      //  imagesView?.setOnClickListener {
      //      it.findNavController().navigate(R.id.action_homeFragment_to_restoFragment)
      //  }
    }
}