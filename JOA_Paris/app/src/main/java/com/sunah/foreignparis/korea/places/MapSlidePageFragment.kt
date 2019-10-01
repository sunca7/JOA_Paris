package com.sunah.foreignparis.korea.places

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.sunah.foreignparis.korea.R
import com.sunah.foreignparis.korea.places.model.PlaceInfoModel
import kotlinx.android.synthetic.main.map_pager_item.*
import kotlinx.android.synthetic.main.pager_item.*

class MapSlidePageFragment : Fragment() {

    companion object{

        private const val PLACE_KEY =  "PLACE_KEY"

        fun newInstance(mapPlace: PlaceInfoModel): MapSlidePageFragment{
            val bundle = Bundle()
            val mapParcel = mapPlace
            bundle.putParcelable(PLACE_KEY, mapParcel)

            val fragment = MapSlidePageFragment().apply {
                arguments = bundle
            }
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.map_pager_item, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var placeInfo : PlaceInfoModel? = arguments?.getParcelable(PLACE_KEY)

        if (placeInfo != null) {
            Glide.with(view.context)
                .load(placeInfo.picture)
                .into(map_image)
        }

        tv_map_place.text = placeInfo?.name?.get("en") ?: String()    // ??
    }
}