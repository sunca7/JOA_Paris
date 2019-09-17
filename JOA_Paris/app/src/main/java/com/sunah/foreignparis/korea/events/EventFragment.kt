package com.sunah.foreignparis.korea.events

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sunah.foreignparis.korea.R
import kotlinx.android.synthetic.main.fragment_event.*

class EventFragment : Fragment() {

    private val eventViewModel: EventViewModel by lazy { ViewModelProviders.of(this)[EventViewModel::class.java] }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_event, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        eventViewModel.eventLiveData.observe(this, Observer {
            event_recycler_view.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = EventAdapter(it)
            }
        })
        eventViewModel.getEvents()
    }
}
