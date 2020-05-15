package com.example.myapplication.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.api.RetrofitApi
import com.example.myapplication.api.RetrofitInterfaceApi
import com.example.myapplication.model.Berita
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    companion object{
        fun getBerita():MutableLiveData<Berita> {
            val data:MutableLiveData<Berita> = MutableLiveData()

            val api:RetrofitInterfaceApi = RetrofitApi.getRetofit("https://berita-news.herokuapp.com/").create(RetrofitInterfaceApi::class.java)

            val call:Call<Berita> = api.getPhotos()

            call.enqueue(object : Callback<Berita>{
                override fun onFailure(call: Call<Berita>, t: Throwable) {
                    Log.d("Error", t.message.toString())
                }

                override fun onResponse(call: Call<Berita>, response: Response<Berita>) {
                    data.value = response.body()
                }

            })

            return data
        }
    }
}