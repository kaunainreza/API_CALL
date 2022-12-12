package com.example.apicall.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apicall.api.ApiInterface
import com.example.apicall.model.Jokes

class MemesRepo (private val apiInterface: ApiInterface){

    private val memesLiveData = MutableLiveData<Jokes>()

    val memes: LiveData<Jokes>
    get() = memesLiveData

    suspend fun getMemes(){
        val result = apiInterface.getJokes()
        if (result.body() != null){
            memesLiveData.postValue(result.body())
        }
    }
}