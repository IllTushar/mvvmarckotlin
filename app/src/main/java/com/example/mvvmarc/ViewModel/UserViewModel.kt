package com.example.mvvmarc.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmarc.Model.DataResponse
import com.example.mvvmarc.Repository.UserRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//In the ViewModel, we fetch the data using the repository and expose it to the View using LiveData.
class UserViewModel : ViewModel() {
    private val userRepository = UserRepository()
    /*
    * _userResponse is declared as MutableLiveData<DataResponse>,
       which means it can be modified (i.e., you can use methods like setValue() or postValue()
       to update its value).
     * However, exposing a MutableLiveData to other classes would allow them to directly modify
       the data, which can lead to unintended consequences.
     * By exposing only the LiveData version (response), you ensure that other classes can observe
       the data but cannot modify it.
     */
    private val _userResponse = MutableLiveData<DataResponse>()
    val response: LiveData<DataResponse> = _userResponse

    fun fetchUser() {
        userRepository.getUser().enqueue(object : Callback<DataResponse> {
            override fun onResponse(call: Call<DataResponse>, response: Response<DataResponse>) {
                _userResponse.value = response.body()
            }

            override fun onFailure(call: Call<DataResponse>, t: Throwable) {
                Log.d("userModel", t.toString())
            }

        })
    }
}