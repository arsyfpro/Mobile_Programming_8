package com.example.mobile_programming_8.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CountryDetail(
    var countryId : Int?,
    var countryName : String?,
    var countryArea : String?,
    var countryPopulation : Int?,
    var countryDescription : String
) : Parcelable