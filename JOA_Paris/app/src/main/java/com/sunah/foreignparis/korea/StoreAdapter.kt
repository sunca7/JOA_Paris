package com.sunah.foreignparis.korea

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class StoreAdapter (var storeModel:List<StoreInfoModel>) :
        RecyclerView.Adapter<StoreViewHolder>() {

    override fun getItemCount() = storeModel.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return StoreViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        holder.bind(storeModel[position])
    }
}

class StoreViewHolder (inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.store_list, parent, false)){

    private var namesView: TextView? = null
    private var imagesView: ImageView? = null

    init {
        namesView = itemView.findViewById(R.id.tv_store_list)
        imagesView = itemView.findViewById(R.id.iv_store)
    }

    fun bind (storeInfoModel: StoreInfoModel) {
        namesView?.text = storeInfoModel.name["en"]
        imagesView?.let {
            if (it != null) {
                Glide.with(itemView.context)
                    .load(storeInfoModel.picture)
                    .centerCrop()
                    .into(it)
            }
        }

        //  imagesView?.setOnClickListener {
        //      it.findNavController().navigate(R.id.action_homeFragment_to_restoFragment)
        //  }

    }

}