package com.sunah.foreignparis.korea


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_resto.*
import java.util.*

class RestoFragment : Fragment() {

    private val restoViewModel: RestoViewModel by lazy { ViewModelProviders.of(this)[RestoViewModel::class.java] }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_resto, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        restoViewModel.restoLiveData.observe(this, Observer{
            resto_recycler_view.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = RestoAdapter(it)
            }
        })

        restoViewModel.getRestos()
    }
}
