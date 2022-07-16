package com.example.retrofitlogin

import okhttp3.Response
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api
{
  // https://demo.parklinq.com/api/kiosk/login//
   @GET("settings")
   suspend fun getPost(): retrofit2.Response<settings>

   @FormUrlEncoded
   @POST("login")
   suspend fun pushpost(
       @Field("email") email: String,
       @Field("password") password: String,
      ): retrofit2.Response<data>


}