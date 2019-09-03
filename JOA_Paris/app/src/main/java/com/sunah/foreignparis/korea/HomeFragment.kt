package com.sunah.foreignparis.korea


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.gson.internal.bind.ObjectTypeAdapter
import com.google.protobuf.Internal
import io.opencensus.metrics.LongGauge
import io.opencensus.tags.Tag
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {


    val db = FirebaseFirestore.getInstance()

    val categoryDoc = db.collection("categories")
        //  val query = db.collection("categories").orderBy("order", Query.Direction.ASCENDING)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        home_view.apply {
                categoryDoc.orderBy("order", Query.Direction.ASCENDING).get()
                .addOnSuccessListener { result ->
                    val categories = mutableListOf<CategoryInfo>()
                 //   val categoryInfo = result.documents[0].toObject(CategoryInfo::class.java)
                    for (document in result.documents) {
                        val tmpCat = document.toObject(CategoryInfo::class.java)
                        if (tmpCat != null) {
                            categories.add(tmpCat)
                        }
                    }
                    val obj_adapter = HomeAdapter(categories)
                    home_view.layoutManager = LinearLayoutManager(activity)
                    home_view.adapter = obj_adapter
                }
            }
        }


           /* categoryDoc.get()
          .addOnSuccessListener {result ->
          val categoryInfo = result.documents[0].toObject(CategoryInfo::class.java)
          category_one.text = categoryInfo?.name?.get("en") ?:"Error"     // ? null가능 또는 찾는게 없으면?
      }
      .addOnFailureListener{
          category_one.text = "error"
          it.printStackTrace()

      }
} */
}
