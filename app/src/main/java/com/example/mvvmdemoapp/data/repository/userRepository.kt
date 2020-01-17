package com.example.mvvmdemoapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmdemoapp.data.network.MyApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class userRepository {

    fun userLogin(email:String,password:String):LiveData<String>{
        val loginResponse=MutableLiveData<String>()
        MyApi().userLogin(email,password)
            .enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    loginResponse.value=t.message
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if (response.isSuccessful){
                        loginResponse.value=response.body()?.string()
                    }
                    else{
                        loginResponse.value=response.errorBody()?.string()
                    }
                }
            })

        return loginResponse
    }
}