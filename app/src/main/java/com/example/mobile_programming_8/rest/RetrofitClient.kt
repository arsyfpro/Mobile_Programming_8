package com.example.mobile_programming_8.rest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    //    private const val BASE_URL = "http://192.168.248.142/ClassIn-API/"
    private const val BASE_URL = "http://192.168.1.7/api-country/"

    val instance: API by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(API::class.java)
    }
}