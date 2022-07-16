package com.example.retrofitlogin

import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val request=chain.request().newBuilder().addHeader("Content-Type","appliction/json")
        .addHeader("X-Platform", "Android").addHeader("Content-Type", "application/x-www-form-urlencoded")
            .addHeader("Cookie", "CAKEPHP=qg4sgmnmar92rbp79fogrq1ohr")
            .build()
        return chain.proceed(request)
    }


}