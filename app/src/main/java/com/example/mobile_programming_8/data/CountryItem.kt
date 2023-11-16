package com.example.mobile_programming_8.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CountryItem(
    val countryId : Int?,
    val countryName : String?,
    val countryArea : String?
) : Parcelable