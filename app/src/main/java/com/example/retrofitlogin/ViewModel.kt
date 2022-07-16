package com.example.retrofitlogin

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class ViewModel (application: Application): AndroidViewModel(Application()) {

    val respository =repository()

    val mypushresponse: MutableLiveData<Response<data>> = MutableLiveData()
    val getresponse: MutableLiveData<Response<settings>> = MutableLiveData()



    fun getPosts()
    {
        viewModelScope.launch {
            val response = respository.getPosts()
              getresponse.value= response

        }

    }

    fun pushPosts(email:String,password:String)
    {
        viewModelScope.launch {
            val response = respository.pushPosts(email,password)
            mypushresponse.value= response
        }
    }


}