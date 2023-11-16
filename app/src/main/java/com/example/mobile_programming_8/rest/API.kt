package com.example.mobile_programming_8.rest

import com.example.mobile_programming_8.data.CountryDetail
import com.example.mobile_programming_8.data.CountryItem
import retrofit2.Call
import retrofit2.http.*

interface API {
    @GET("read.php")
    fun getCountries():Call<ArrayList<CountryItem>>

    @GET("detail.php")
    fun getCountryDetail(
        @Query("countryId") countryId: String?
    ):Call<CountryDetail>
}