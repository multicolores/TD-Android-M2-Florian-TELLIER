package com.example.myapplication.architecture

import com.example.myapplication.data.remote.YuGiOhEndpoint
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://db.ygoprodeck.com/api/v7/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()

    fun getYuGiOhCard(): YuGiOhEndpoint = retrofit.create(YuGiOhEndpoint::class.java)
}
