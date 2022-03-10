package com.ufukgungor.kpssydsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun kpssStudy(view: View){

    }
    fun ydsStudy(view : View){

    }
    fun loginTransfer(view: View){
        val intent= Intent(applicationContext,LoginActivity::class.java)
        startActivity(intent)
    }
    fun registerTransfer(view: View){
        val intent= Intent(applicationContext,RegisterActivity::class.java)
        startActivity(intent)
    }

}