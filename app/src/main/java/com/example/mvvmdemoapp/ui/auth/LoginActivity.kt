package com.example.mvvmdemoapp.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmdemoapp.R
import com.example.mvvmdemoapp.databinding.ActivityLoginBinding
import com.example.mvvmdemoapp.utils.toast

class LoginActivity : AppCompatActivity(),AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityLoginBinding=DataBindingUtil.setContentView(this,R.layout.activity_login)
        val viewModel=ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewmodel=viewModel

        viewModel.authListener=this
    }

    override fun onStarted() {
        toast("Login Started")
        println("hello")
    }

    override fun onSuccess(loginResponse: LiveData<String>) {
        loginResponse.observe(this, Observer {
            toast(it)
        })
    }

    override fun onFailur(msg: String) {
        toast(msg)
    }
}
