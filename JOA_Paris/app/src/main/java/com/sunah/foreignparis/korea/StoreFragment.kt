package com.sunah.foreignparis.korea

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_resto.*
import kotlinx.android.synthetic.main.fragment_store.*

class StoreFragment : Fragment() {

    private val storeViewModel: StoreViewModel by lazy { ViewModelProviders.of(this)[StoreViewModel::class.java] }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_store, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        storeViewModel.storeLiveData.observe(this, Observer {
            store_recycler_view.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = StoreAdapter(it)
            }
        })
        storeViewModel.getStores()
    }
}
