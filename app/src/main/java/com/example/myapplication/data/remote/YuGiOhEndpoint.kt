package com.example.myapplication.data.remote

import com.example.myapplication.data.model.YuGiOhDto
import retrofit2.http.GET


interface YuGiOhEndpoint {
    @GET("randomcard.php")
    suspend fun getRandomCard() : YuGiOhDto
}
