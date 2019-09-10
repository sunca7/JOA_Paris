package com.sunah.foreignparis.korea

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import java.lang.Exception

class StoreViewModel : ViewModel() {
    val storeLiveData = MutableLiveData<List<StoreInfoModel>>()

    val db = FirebaseFirestore.getInstance().collection("places")

    fun getStores() {
        db.orderBy("name", Query.Direction.ASCENDING).get()
            .addOnSuccessListener { result ->
                val stores = mutableListOf<StoreInfoModel>()
                for (document in result.documents) {
                    try {
                        val tmpStore = document.toObject(StoreInfoModel::class.java)
                        if (tmpStore != null) {
                            stores.add(tmpStore)
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
                storeLiveData.value = stores
            }
            .addOnFailureListener() {
                it.printStackTrace()
            }
    }
}