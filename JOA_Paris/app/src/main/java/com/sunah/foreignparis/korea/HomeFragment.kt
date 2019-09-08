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

class HomeFragment : Fragment() {


    private val viewModel: HomeViewModel by lazy { ViewModelProviders.of(this)[HomeViewModel::class.java] }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.categoryLiveData.observe(this, Observer {
            home_recycler_view.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = HomeAdapter(it)
            }
        })

        viewModel.getCategories()
    }

}
