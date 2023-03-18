package com.example.lektion_10_api.api

import retrofit2.Call
import retrofit2.http.GET

interface FoxApi {

    @GET("/floof/")
    fun getRandomFox(): Call<Fox>

}