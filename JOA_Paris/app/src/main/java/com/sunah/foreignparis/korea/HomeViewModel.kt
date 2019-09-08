package com.sunah.foreignparis.korea

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import java.lang.Exception

class HomeViewModel : ViewModel() {
    val categoryLiveData = MutableLiveData<List<CategoryInfoModel>>()

    val db = FirebaseFirestore.getInstance().collection("categories")

    fun getCategories() {
        db.orderBy("order", Query.Direction.ASCENDING).get()
            .addOnSuccessListener { result ->
                val categories = mutableListOf<CategoryInfoModel>()
                for (document in result.documents) {
                    try {
                        val tmpCat = document.toObject(CategoryInfoModel::class.java)
                        if (tmpCat != null) {
                            categories.add(tmpCat)
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
                categoryLiveData.value = categories
            }
            .addOnFailureListener() {
                it.printStackTrace()
            }
    }
}
