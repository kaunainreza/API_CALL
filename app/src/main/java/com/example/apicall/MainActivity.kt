package com.example.apicall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.viewModelScope
import com.example.apicall.api.ApiInterface
import com.example.apicall.api.ApiUtilities
import com.example.apicall.repository.MemesRepo
import com.example.apicall.viewmodel.MemesViewModel
import com.example.apicall.viewmodel.MemesViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var memesViewModel: MemesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiInterface = ApiUtilities.getInstance().create(ApiInterface::class.java)
        val memesRepo = MemesRepo(apiInterface)

        memesViewModel = ViewModelProvider(this, MemesViewModelFactory(memesRepo)).get()
        (MemesViewModel::class.java) //some things

        memesViewModel.memes.observe(this, { Log.d("SHUBH", "onCreate: ${it.toString()} ")
        })
    }
}