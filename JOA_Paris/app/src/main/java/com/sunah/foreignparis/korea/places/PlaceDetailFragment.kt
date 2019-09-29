package com.sunah.foreignparis.korea.places

import android.content.Intent
import android.icu.text.Transliterator
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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

            val urlList = mutableListOf<String>()

            urlList.add(place.picture)
            urlList.addAll(place.secondary_pictures)

            view_pager_header.adapter = ViewPageAdapter(childFragmentManager, view.context, urlList)

            list_item_schedule.setHtmlInfo(R.drawable.ic_query_builder_24px, place.schedule["en"])
            list_item_phone.setInfo(R.drawable.ic_call_24px, place.phone)
            list_item_phone.setOnClickListener {
                val intent_dial = Intent(Intent.ACTION_DIAL);
                intent_dial.data = Uri.parse("tel:${place.phone}")
                startActivity(intent_dial)
            }
            list_item_address.setInfo(R.drawable.ic_map_24px, place.address)
            list_item_address.setOnClickListener {
                val gmmIntentUri =
                    Uri.parse("geo:0,0?q=${place.address}")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")
                startActivity(mapIntent)
                list_item_web.setInfo(R.drawable.ic_insert_link_24px, place.website)
                list_item_web.setOnClickListener {
                    val url = "${place.website}"
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

                    if (intent.resolveActivity(activity?.packageManager!!) != null) {
                        startActivity(intent)
                    }
                }
                list_item_share.setInfo(R.drawable.ic_share_24px, "Share")
            }

        }
    }
}