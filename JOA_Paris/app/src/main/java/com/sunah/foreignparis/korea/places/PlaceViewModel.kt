package com.sunah.foreignparis.korea.places

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.sunah.foreignparis.korea.places.model.PlaceInfoModel
import java.lang.Exception

class PlaceViewModel :ViewModel(){
    val placeLiveData = MutableLiveData<List<PlaceInfoModel>>()

    val db = FirebaseFirestore.getInstance().collection("places")


    fun getPlaces(categoryId:String) {
        db.whereEqualTo("category_id", categoryId).get()
            .addOnSuccessListener { result ->
                val places  = mutableListOf<PlaceInfoModel>()
                for (document in result.documents) {
                    try {
                        val tmpPlace = document.toObject(PlaceInfoModel::class.java)
                        if (tmpPlace != null) {
                            places.add(tmpPlace)
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
                placeLiveData.value = places
            }
            .addOnFailureListener {
                it.printStackTrace()
            }
    }
}