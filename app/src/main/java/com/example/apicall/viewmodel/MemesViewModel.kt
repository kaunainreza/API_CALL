package com.example.apicall.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apicall.model.Jokes
import com.example.apicall.repository.MemesRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemesViewModel (private val memesRepo: MemesRepo):ViewModel(){

    init {
        viewModelScope.launch (Dispatchers.IO){
            memesRepo.getMemes()
        }
    }
    val memes: LiveData<Jokes>
    get() = memesRepo.memes
}