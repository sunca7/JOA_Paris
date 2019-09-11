package com.sunah.foreignparis.korea


import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.util.AttributeSet
import android.widget.Toast
import androidx.databinding.DataBindingUtil.setContentView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.sunah.foreignparis.korea.R.layout.fragment_resto


class MapFragment : SupportMapFragment(), OnMapReadyCallback {

    private lateinit var map: GoogleMap

    var initial_latitude  = 48.8566
    var initial_longitude = 2.3522
    var initial_marker    = "Paris"


    @SuppressLint("MissingSuperCall")
    override fun onInflate(activity: Activity, attrs: AttributeSet, savedInstanceState: Bundle?) {
        if (context != null) {
            if (attrs != null) {
                super.onInflate(context!!, attrs, savedInstanceState)
            }
        }
        attrs ?: return
        context ?: return
    }

  /*
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(fragment_resto, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.fragment_map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    val mapFragment = supportFragmentManager.findFragmentById(R.id.fragment_map) as SupportMapFragment
    mapFragment.getMapAsync(this)


   
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.fragment_map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

      */
    override fun onMapReady(map: GoogleMap?) {
        System.err.println("OnMapReady start")
        this.map = map as GoogleMap

     //   val paris = LatLng(initial_latitude, initial_longitude)
     //   map.addMarker(MarkerOptions().position(paris).title(initial_marker))
     //   map.moveCamera(CameraUpdateFactory.newLatLng(paris))
     //   Toast.makeText(this.context, "OnMapReady end", Toast.LENGTH_LONG).show()
    }

}
