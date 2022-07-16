package com.example.retrofitlogin

import com.example.retrofitlogin.utils.Companion.BASE_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {

        var retrofitService: Api? = null

    private val client= OkHttpClient.Builder().apply {
        addInterceptor(MyInterceptor())

    }.build()

        fun getInstance() : Api {
            val gson:Gson =GsonBuilder().setLenient().create()
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL).client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
                retrofitService = retrofit.create(Api::class.java)
            }
            return retrofitService!!
        }


}