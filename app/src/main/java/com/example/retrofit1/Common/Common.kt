package com.example.retrofit1.Common

import com.example.retrofit1.Interface.MyRetrofitServices
import com.example.retrofit1.Retrofit.RetrofitClient

object Common {
    private val BASE_URL = "https://media.novotelecom.ru/ntk-tvguide/v1/"
    val myRetrofitService: MyRetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(MyRetrofitServices::class.java)
}