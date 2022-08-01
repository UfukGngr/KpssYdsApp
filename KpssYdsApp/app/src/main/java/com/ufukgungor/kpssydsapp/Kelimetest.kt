package com.ufukgungor.kpssydsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import com.ufukgungor.kpssydsapp.databinding.ActivityKelimelerBinding

import com.ufukgungor.kpssydsapp.databinding.ActivityKelimetestBinding

class Kelimetest : AppCompatActivity() {
    private lateinit var binding : ActivityKelimetestBinding

    var number = 1
    var soru2="The malaria parasite is a much more ---- and devious opponent than we ever "

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding= ActivityKelimetestBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        setContentView(R.layout.activity_kelimetest)

        val textView: TextView = findViewById(R.id.soru1) as TextView
        var increaseBtn: Button = findViewById(R.id.sonrakiSoru) as Button
        var decreaseBtn: Button = findViewById(R.id.oncekiSoru) as Button

        increaseBtn.setOnClickListener {
            number++
            textView.text = soru2

        }
        decreaseBtn.setOnClickListener {
            number--
            textView.text = number.toString();
        }
    }

}