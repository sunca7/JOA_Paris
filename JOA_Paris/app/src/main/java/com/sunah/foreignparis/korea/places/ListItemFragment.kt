package com.sunah.foreignparis.korea.places

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sunah.foreignparis.korea.R


@SuppressLint("ParcelCreator")
class ListItemFragment() : Fragment(), Parcelable {

    private lateinit var myObject: ListItemFragment

    constructor(parcel: Parcel) : this() {
        myObject = parcel.readParcelable(ListItemFragment::class.java.classLoader)!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (arguments != null) {
            myObject = arguments!!.getParcelable(ARG_PARAM)!!
        }

     //   val bundle = intent.getBundleExtra("Bundle")
     //   val object = bundle.getParcelable<ListItemInfoModel>("key")
        return inflater.inflate(R.layout.list_item_view, container, false)
    }

    companion object {
        private val ARG_PARAM = "myObject"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param myObject as MyObject.
         * @return A new instance of fragment MyFragment.
         */
        fun newInstance(myObject: ListItemFragment): ListItemFragment {
            val fragment = ListItemFragment()
            val args = Bundle()
            args.putParcelable(ARG_PARAM, myObject)
            fragment.arguments = args
            return fragment
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(myObject, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

}
