package com.ufukgungor.kpssydsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ufukgungor.kpssydsapp.databinding.ActivityYdsactivityBinding

class Ydsactivity : AppCompatActivity() {

    private lateinit var binding: ActivityYdsactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityYdsactivityBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
    }
    fun kelimelerSayfasi(view: View){
        val intent=Intent(applicationContext,Kelimeler::class.java)
        startActivity(intent)
    }
    fun kelimeTesti(view: View){
        val intent=Intent(applicationContext,Kelimetest::class.java)
        startActivity(intent)
    }

}