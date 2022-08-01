package com.ufukgungor.kpssydsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import com.ufukgungor.kpssydsapp.databinding.ActivityGoogleLoginBinding
import com.ufukgungor.kpssydsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        veritabaniKopyala()

    }
    fun kpssStudy(view: View){
        val intent=Intent(applicationContext,KpssActivity::class.java)
        startActivity(intent)
    }
    fun ydsStudy(view : View){
        val intent=Intent(applicationContext,Ydsactivity::class.java)
        startActivity(intent)
    }
    fun loginTransfer(view: View){
        val intent= Intent(applicationContext,GoogleLogin::class.java)
        startActivity(intent)
    }
    fun veritabaniKopyala() {
        val copyHelper = DatabaseCopyHelper(this)

        try {
            copyHelper.createDataBase()
            copyHelper.openDataBase()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}