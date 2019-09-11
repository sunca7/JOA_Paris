package com.sunah.foreignparis.korea

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import java.lang.Exception

class EventViewModel : ViewModel() {
    val eventLiveData = MutableLiveData<List<EventInfoModel>>()

    val db = FirebaseFirestore.getInstance().collection("events")

    fun getEvents() {
        db.get()
            .addOnSuccessListener { result ->
                val events = mutableListOf<EventInfoModel>()
                for (document in result.documents) {
                    try {
                        val tmpEvent = document.toObject(EventInfoModel::class.java)
                        if (tmpEvent != null) {
                            events.add(tmpEvent)
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
                eventLiveData.value = events
            }
            .addOnFailureListener {
                it.printStackTrace()
            }
    }
}