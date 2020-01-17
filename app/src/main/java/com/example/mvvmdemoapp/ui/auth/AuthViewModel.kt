package com.example.mvvmdemoapp.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvmdemoapp.data.repository.userRepository

class AuthViewModel :ViewModel() {
    var email:String?=null
    var password:String?=null
    var authListener:AuthListener?=null

    fun onLoginButtonIsClicked(view:View){

        authListener?.onStarted()
        if (email.isNullOrEmpty()||password.isNullOrEmpty()){
            authListener?.onFailur("Invalid email or password")
            return
        }

        val loginResponse=userRepository().userLogin(email!!,password!!)

        authListener?.onSuccess(loginResponse)
    }
}