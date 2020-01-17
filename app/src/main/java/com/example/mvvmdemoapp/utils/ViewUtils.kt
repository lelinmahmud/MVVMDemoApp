package com.example.mvvmdemoapp.utils

import android.content.Context
import android.widget.Toast
import es.dmoral.toasty.Toasty

fun Context.toast(msg:String){
    Toasty.success(this,msg,Toast.LENGTH_SHORT).show()
}
