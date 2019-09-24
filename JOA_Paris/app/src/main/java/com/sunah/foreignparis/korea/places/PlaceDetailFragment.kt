package com.sunah.foreignparis.korea.places

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.sunah.foreignparis.korea.R
import com.sunah.foreignparis.korea.places.model.PlaceInfoModel
import kotlinx.android.synthetic.main.fragment_place_detail.*

class PlaceDetailFragment: Fragment() {

    private lateinit var place :PlaceInfoModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_place_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            place = it.getParcelable("Details")!!

            iv_place?.let {
                Glide.with(view.context)
                    .load(place.picture)
                    .centerCrop()
                    .into(it)
            }

            list_item_schedule.setHtmlInfo(R.drawable.ic_query_builder_24px, place.schedule["en"]!!)
            list_item_schedule.setOnClickListener{

            }
            list_item_phone.setInfo(R.drawable.ic_call_24px, place.phone)
            list_item_address.setInfo(R.drawable.ic_map_24px, place.address)
            list_item_web.setInfo(R.drawable.ic_insert_link_24px, place.website)
            list_item_share.setInfo(R.drawable.ic_share_24px, "Share")
        }
        
    }
}