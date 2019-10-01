package com.sunah.foreignparis.korea.places

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.sunah.foreignparis.korea.places.model.PlaceInfoModel

class MapViewPagerAdapter(fm: FragmentManager, private var context: Context, private val listPlaces: List<PlaceInfoModel>) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return MapSlidePageFragment.newInstance(listPlaces[position])
    }

    override fun getCount(): Int {
        return listPlaces.size
    }

}