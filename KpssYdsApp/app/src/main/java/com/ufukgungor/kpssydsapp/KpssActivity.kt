package com.ufukgungor.kpssydsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import com.ufukgungor.kpssydsapp.databinding.ActivityKpssBinding

class KpssActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKpssBinding
    var baslik1: String = "Tarih"
    var baslik2: String = "Coğrafya"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKpssBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.testButton.text = baslik1
        binding.testButton2.text = baslik2

    }
    fun backback2(view: View){
        val intent = Intent(this@KpssActivity, MainActivity::class.java)
        startActivity(intent)
    }
    fun tarihTest(view: View) {
        val intent = Intent(this@KpssActivity, ShowActivity::class.java)
        startActivity(intent)
    }

   /* fun cografyaTest(view: View) {
        val intent = Intent(this@KpssActivity, ShowActivity::class.java)
    }*/


}
