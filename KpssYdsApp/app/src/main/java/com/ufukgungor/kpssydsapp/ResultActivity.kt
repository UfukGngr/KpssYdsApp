package com.ufukgungor.kpssydsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ufukgungor.kpssydsapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dogruSayac = intent.getIntExtra("dogruSayac",0)

        binding.textViewSonuc.text = "$dogruSayac DOĞRU ${5-dogruSayac} YANLIŞ"

        binding.textViewBasariYuzdesi.text = "% ${(dogruSayac*100)/5} Başarı"

    }
    fun basaDon(view: View){
        intent= Intent(this@ResultActivity,KpssActivity::class.java)
        startActivity(intent)
    }
    fun enBasaDon(view: View){
        intent= Intent(this@ResultActivity,MainActivity::class.java)
        startActivity(intent)
    }
}