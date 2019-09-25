package com.sunah.foreignparis.korea.places

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.sunah.foreignparis.korea.R
import com.sunah.foreignparis.korea.places.model.PlaceInfoModel
import kotlinx.android.synthetic.main.fragment_place_detail.*
import kotlinx.android.synthetic.main.fragment_place_detail.view.*

private const val NUM_PAGES = 5

class PlaceDetailFragment: Fragment() {

    private lateinit var place :PlaceInfoModel

    private lateinit var mPager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mPager = iv_place.view_pager as ViewPager

        val pagerAdapter = ScreenSlidePagerAdapter(childFragmentManager)
        mPager.adapter = pagerAdapter

        return inflater.inflate(R.layout.fragment_place_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val pagerAdapter = ScreenSlidePagerAdapter(childFragmentManager)
        mPager.adapter = pagerAdapter

        arguments?.let {
            place = it.getParcelable("Details")!!

            list_item_schedule.setHtmlInfo(R.drawable.ic_query_builder_24px, place.schedule["en"]!!)
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

    private inner class ScreenSlidePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        override fun getCount(): Int = NUM_PAGES

        override fun getItem(position: Int): Fragment = ScreenSlidePageFragment()
    }

}