package com.sunah.foreignparis.korea


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.sunah.foreignparis.korea.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 */
/*
data class CategoriesNames(
    var nameOne: String = "",
    var nameTwo: String = "",
    var nameThree: String = "",
    var nameFour: String = "")
*/

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }
}
