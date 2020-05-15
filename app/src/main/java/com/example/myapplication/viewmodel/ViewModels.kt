package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.Berita
import com.example.myapplication.repository.Repository

class ViewModels : ViewModel(){
    var data:MutableLiveData<Berita>? = null

    fun init(){
        if (data != null) {
            data = null
        }

        data = Repository.getBerita()
    }

    fun getData():LiveData<Berita> {
        return data!!
    }
}