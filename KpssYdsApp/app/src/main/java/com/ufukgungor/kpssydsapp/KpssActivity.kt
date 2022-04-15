package com.ufukgungor.kpssydsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ufukgungor.kpssydsapp.databinding.ActivityKpssBinding
import com.ufukgungor.kpssydsapp.databinding.ActivityMainBinding

class KpssActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKpssBinding
    private lateinit var pdfList: ArrayList<Pdf>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKpssBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        pdfList=ArrayList<Pdf>()
        val tarih=Pdf("Tarih")
        val cografya=Pdf("Cografya")

        pdfList.add(tarih)
        pdfList.add(cografya)

        binding.kpssrecylerView.layoutManager=LinearLayoutManager(this)
        val adapter=PdfAdapter(pdfList)
        binding.kpssrecylerView.adapter=adapter
    }
}