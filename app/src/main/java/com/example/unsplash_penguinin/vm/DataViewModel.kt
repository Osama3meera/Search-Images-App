package com.example.unsplash_penguinin.vm

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.unsplash_penguinin.data.Repository
import com.example.unsplash_penguinin.model.Results

class DataViewModel : ViewModel() {

    var result = MutableLiveData<ArrayList<Results>>()

    fun search(context: Context, searchQuery: String): MutableLiveData<ArrayList<Results>> {

        val repository = Repository()
        result = repository.search(context, searchQuery)
        return repository.search(context, searchQuery)
    }
}