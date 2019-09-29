package com.sunah.foreignparis.korea.places.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class PlaceInfoModel
    : Parcelable {
    val category: Int = 0
    var name: Map <String, String> = emptyMap()
    var schedule: Map <String, String> = emptyMap()
    var secondary_pictures: List<String> = emptyList()
    val address: String = ""
    val latitude: Double = 0.0
    val longitude: Double = 0.0
    val phone: String = ""
    val picture: String= ""
    val website: String= ""
    val foursquare: String= ""
}