package com.sunah.foreignparis.korea.places

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.sunah.foreignparis.korea.R
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.bumptech.glide.Glide


class ViewPageAdapter(fm: FragmentManager, private var context: Context, private val listUrl: List<String>) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return ScreenSlidePageFragment.newInstance(listUrl[position])
    }

    override fun getCount(): Int {
        return listUrl.size
    }

}