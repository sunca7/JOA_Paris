package com.sunah.foreignparis.korea.places.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListItemInfoModel(
    val itemName: String,
    val itemPicture : String
    ) : Parcelable {}