package com.example.mvvmarc.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    const val BASE_URL: String = "https://reqres.in/"
    val retrofit: Retrofit by lazy {
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiServices: ApiServices by lazy {
        retrofit.create(ApiServices::class.java)
    }
}