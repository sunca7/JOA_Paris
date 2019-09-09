package com.sunah.foreignparis.korea

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import java.lang.Exception

class RestoViewModel :ViewModel(){
    val restoLiveData = MutableLiveData<List<RestoInfoModel>>()

    val db = FirebaseFirestore.getInstance().collection("places")


    fun getRestos() {
        db.orderBy("name", Query.Direction.ASCENDING).get()
            .addOnSuccessListener { result ->
                val restos = mutableListOf<RestoInfoModel>()
                for (document in result.documents) {
                    try {
                        val tmpRes = document.toObject(RestoInfoModel::class.java)
                        if (tmpRes != null) {
                            restos.add(tmpRes)
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
                restoLiveData.value = restos
            }
            .addOnFailureListener() {
                it.printStackTrace()
            }
    }
}