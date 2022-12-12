package com.example.apicall.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apicall.repository.MemesRepo

class MemesViewModelFactory (private val memesRepo: MemesRepo):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MemesViewModel(memesRepo) as T
    }

}