package com.example.retrofitlogin

import retrofit2.Call
import retrofit2.Response

class repository  {

    suspend fun getPosts():Response<settings> {
        return RetrofitObject.getInstance().getPost()
    }


    suspend fun pushPosts(email:String,password : String) : Response<data>
    {
        return RetrofitObject.getInstance().pushpost(email,password)
    }
}