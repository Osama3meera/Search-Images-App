package com.example.unsplash_penguinin.data.retrofit

import com.example.unsplash_penguinin.model.Photos
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AppApi {

    @GET("search/photos")
    fun search(
        @Query("client_id") clientID: String,
        @Query("query") searchQuery: String,
        @Query("page") page: String,
        @Query("per_page") per_page: String,
    ): Call<Photos>

}

