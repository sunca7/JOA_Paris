package com.sunah.foreignparis.korea.places

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.sunah.foreignparis.korea.R
import com.sunah.foreignparis.korea.places.model.PlaceInfoModel
import kotlinx.android.synthetic.main.fragment_place.*
import kotlinx.android.synthetic.main.fragment_place.view.*

class PlaceFragment : Fragment(), OnMapReadyCallback {

    private val placeViewHolder: PlaceViewModel by lazy { ViewModelProviders.of(this)[PlaceViewModel::class.java]}

    private var categoryId: String? = ""

    private lateinit var mMap: GoogleMap


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (arguments != null) {
            categoryId = arguments?.getString("categoryId")
        }
        return inflater.inflate(R.layout.fragment_place, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        placeViewHolder.placeLiveData.observe(this, Observer {
            prograssbar_places.visibility = View.GONE
            for (item in it) {
                val place = LatLng(item.latitude, item.longitude)
                mMap.addMarker(MarkerOptions().position(place).title(item.name["en"]))
            }
            place_recycler_view.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = PlaceAdapter(it)
            }
        })

        placeViewHolder.getPlaces(categoryId.toString())

        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        view.button.setOnClickListener {
            if (place_recycler_view.visibility == View.GONE) {
                map_frame.visibility = View.GONE
                place_recycler_view.visibility = View.VISIBLE
                button.text = getString(R.string.button_map)
            } else {
                map_frame.visibility = View.VISIBLE
                place_recycler_view.visibility = View.GONE
                button.text = getString(R.string.button_list)
            }
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val paris = LatLng(48.8566, 2.3522)

        mMap.moveCamera(CameraUpdateFactory.newLatLng(paris))
        mMap.animateCamera(
            CameraUpdateFactory.newCameraPosition(
                CameraPosition.fromLatLngZoom(paris, 12F)
            )
        )
    }
}