package com.sunah.foreignparis.korea.places

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.sunah.foreignparis.korea.places.model.PlaceInfoModel

class PlaceDetailFragment: Fragment() {

    private lateinit var place :PlaceInfoModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            place = it.getParcelable("Details")!!
            val placename : String = place.address
        }
    }
}