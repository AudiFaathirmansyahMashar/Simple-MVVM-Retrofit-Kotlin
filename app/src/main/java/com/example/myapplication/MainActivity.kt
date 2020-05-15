package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.model.Berita
import com.example.myapplication.viewmodel.ViewModels
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModels = ViewModelProvider(this).get(ViewModels::class.java)

        viewModels.init()
        viewModels.getData().observe(this, object : Observer<Berita>{
            override fun onChanged(t: Berita?) {
                text.text = "${t?.data?.get(0)?.judul}\n\n\n ${t?.data?.get(0)?.kutipan}\n\n\n${t?.data?.get(0)?.waktu}"
            }

        })
    }
}
