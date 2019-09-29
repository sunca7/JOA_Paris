package com.sunah.foreignparis.korea.places

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.sunah.foreignparis.korea.R
import kotlinx.android.synthetic.main.pager_item.*
import java.net.URL

class ScreenSlidePageFragment : Fragment() {

    companion object{

        private const val URL_KEY =  "URL_KEY"

        fun newInstance(url: String): ScreenSlidePageFragment{
            val bundle = Bundle()
            bundle.putString(URL_KEY, url)

            val fragment = ScreenSlidePageFragment().apply {
                arguments = bundle
            }

            return fragment
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.pager_item, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pictureUrl = arguments?.getString(URL_KEY)

        if (pictureUrl != null) {
            Glide.with(view.context)
                .load(pictureUrl)
                .into(secondary_image)
        }
    }
}
