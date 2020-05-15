package com.example.myapplication.api

import com.example.myapplication.model.Berita
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterfaceApi {
    @GET("https://berita-news.herokuapp.com/")
    fun getPhotos():Call<Berita>
}