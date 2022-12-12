package com.example.apicall.api

import com.example.apicall.model.Jokes
import okhttp3.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/api")
    suspend fun getJokes() :retrofit2.Response<Jokes>
}