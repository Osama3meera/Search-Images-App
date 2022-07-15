package com.example.unsplash_penguinin.data

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.unsplash_penguinin.data.retrofit.RestClient
import com.example.unsplash_penguinin.model.Photos
import com.example.unsplash_penguinin.model.Results
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    var result = MutableLiveData<ArrayList<Results>>()

    fun search(context: Context, searchQuery: String): MutableLiveData<ArrayList<Results>> {
        RestClient.getService().search(AppConstants.CLIENT_ID, searchQuery)
            .enqueue(object : Callback<Photos> {
                override fun onResponse(call: Call<Photos>, response: Response<Photos>) {
                    if (response.isSuccessful) {

                        result.value = response.body()!!.results

                        Toast.makeText(
                            context,
                            "Photos retrieved Successfully!",
                            Toast.LENGTH_SHORT
                        ).show()

                    } else {
                        Toast.makeText(context, "Failed to Display Photos!", Toast.LENGTH_SHORT)
                            .show()
                    }
                }

                override fun onFailure(call: Call<Photos>, t: Throwable) {
                    Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
                }

            })
        return result
    }
}