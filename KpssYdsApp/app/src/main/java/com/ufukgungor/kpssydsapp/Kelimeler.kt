package com.ufukgungor.kpssydsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ufukgungor.kpssydsapp.databinding.ActivityKelimelerBinding

class Kelimeler: AppCompatActivity() {
    private lateinit var binding: ActivityKelimelerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityKelimelerBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)


    }
    fun ydsSayfa (view: View){
        val intent= Intent(applicationContext,Ydsactivity::class.java)
        startActivity(intent)
}}