package com.example.retrofit1.Interface

import com.example.retrofit1.Model.MChannel
import com.example.retrofit1.Model.MReply
import retrofit2.Call
import retrofit2.http.GET

interface MyRetrofitServices {

    @GET("channels.json")
    fun getChannels(): Call<MReply>

}