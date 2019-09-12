package com.sunah.foreignparis.korea


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_resto.*
import kotlinx.android.synthetic.main.fragment_resto.view.*

class PlaceFragment : Fragment() {

    private val placeViewHolder: PlaceViewModel by lazy { ViewModelProviders.of(this)[PlaceViewModel::class.java] }

    var categoryId: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (arguments != null){
            categoryId = arguments?.getString("categoryId")
        }
        return inflater.inflate(R.layout.fragment_resto, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        placeViewHolder.placeLiveData.observe(this, Observer{
            place_recycler_view.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = PlaceAdapter(it)
            }
        })
        placeViewHolder.getPlaces(categoryId.toString())

        view.button.setOnClickListener {
           // Log.d("btnSetup", "Selected")
              it.findNavController().navigate(R.id.action_placeFragment_to_mapFragment)
        }
    }
}
