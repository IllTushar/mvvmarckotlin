package com.example.mvvmarc.Api

import com.example.mvvmarc.Model.DataResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("api/users")
    fun getUserData(@Query("page") page: Int): Call<DataResponse>
}