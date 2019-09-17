package com.sunah.foreignparis.korea.events

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sunah.foreignparis.korea.R
import com.sunah.foreignparis.korea.events.model.EventInfoModel

class EventAdapter (var eventModel:List<EventInfoModel>) :
        RecyclerView.Adapter<EventViewHolder>() {

    override fun getItemCount() = eventModel.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return EventViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(eventModel[position])
    }
}

class EventViewHolder (inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.event_list, parent, false)){

    private var namesView: TextView? = null
    private var imagesView: ImageView? = null

    init {
        namesView = itemView.findViewById(R.id.tv_event_list)
        imagesView = itemView.findViewById(R.id.iv_event)
    }

    fun bind (eventInfoModel: EventInfoModel) {
        namesView?.text = eventInfoModel.name["en"]
        imagesView?.let {
            if (it != null) {
                Glide.with(itemView.context)
                    .load(eventInfoModel.picture)
                    .centerCrop()
                    .into(it)
            }
        }

        //  imagesView?.setOnClickListener {
        //      it.findNavController().navigate(R.id.action_homeFragment_to_restoFragment)
        //  }

    }

}