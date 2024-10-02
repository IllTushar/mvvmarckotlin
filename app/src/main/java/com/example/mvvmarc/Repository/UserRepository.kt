package com.example.mvvmarc.Repository

import com.example.mvvmarc.Api.RetrofitClient
import com.example.mvvmarc.Model.DataResponse
import retrofit2.Call

//The repository will handle fetching the data from the API and pass it to the ViewModel.
class UserRepository {
    private val apiServices = RetrofitClient.apiServices

    fun getUser(): Call<DataResponse> {
        return apiServices.getUserData(2)
    }
}