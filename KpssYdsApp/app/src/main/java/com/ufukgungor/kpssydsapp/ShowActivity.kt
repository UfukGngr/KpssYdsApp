package com.ufukgungor.kpssydsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import com.ufukgungor.kpssydsapp.databinding.ActivityShowBinding
import kotlin.random.Random

class ShowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShowBinding

    private lateinit var sorular: ArrayList<KpssSorular>
    private lateinit var dogruSoru: KpssSorular
    private lateinit var yanlisSecenekler: ArrayList<KpssSorular>
    private lateinit var dogruCevap: KpssSorular
    private lateinit var yanlisCevap: KpssSorular
    private lateinit var dogruCevaplar:ArrayList<KpssSorular>
    private lateinit var tumSecenekler:ArrayList<KpssSorular>
    private lateinit var vt: VeriTabaniYardimcisi

    private var yanlisSecenek=0
    private var soruSayac =0
    private var dogruSayac=0
    private var yanlisSayac=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        vt=VeriTabaniYardimcisi(this)

        sorular=KpssSorulardao().sorularıGetir(vt)
        dogruCevaplar=KpssSorulardao().dogruCevabıGetir(vt)
        yanlisSecenekler=KpssSorulardao().digerSecenekleriGetir(vt)

        soruYukle()

        binding.aSikki.setOnClickListener{
            dogruKontrol(binding.aSikki)
            soruSayacKontrol()
        }
        binding.bSikki.setOnClickListener{
            dogruKontrol(binding.bSikki)
            soruSayacKontrol()
        }
        binding.cSikki.setOnClickListener{
            dogruKontrol(binding.cSikki)
            soruSayacKontrol()
        }
        binding.dSikki.setOnClickListener{
            dogruKontrol(binding.dSikki)
            soruSayacKontrol()
        }
        binding.eSikki.setOnClickListener{
            dogruKontrol(binding.eSikki)
            soruSayacKontrol()
        }
    }
    fun soruSayacKontrol(){
        soruSayac++

        if (soruSayac!=5){
            soruYukle()

        }else{
            sonucGoster()
        }
    }
    fun soruYukle(){
        binding.textViewSoruSayi.text="${soruSayac+1}. Soru"

        dogruSoru=sorular.get(soruSayac)
        binding.soruGoster.text=dogruSoru.soru
        dogruCevap=dogruCevaplar.get(soruSayac)



        tumSecenekler= ArrayList()
        tumSecenekler.add(dogruCevap)
        tumSecenekler.add(yanlisSecenekler.get(0))
        tumSecenekler.add(yanlisSecenekler.get(1))
        tumSecenekler.add(yanlisSecenekler.get(2))
        tumSecenekler.add(yanlisSecenekler.get(3))

        binding.aSikki.text=tumSecenekler.elementAt(0).dogru_cevap
        binding.bSikki.text=tumSecenekler.elementAt( 1).bSikki
        binding.cSikki.text=tumSecenekler.elementAt(2).cSikki
        binding.dSikki.text=tumSecenekler.elementAt(3).dSikki
        binding.eSikki.text=tumSecenekler.elementAt(4).eSikki

        }
    fun dogruKontrol(button: Button){
        val buttonYazi = button.text.toString()
        val dogru=dogruCevap.dogru_cevap

        if(buttonYazi ==dogru){
            dogruSayac++
        }else{
            yanlisSayac++
        }

        binding.textViewDogru.text = "Doğru : $dogruSayac"
        binding.textViewYanlis.text = "Yanlış : $yanlisSayac"
    }

    fun backback(view: View){
        val intent= Intent(this@ShowActivity,MainActivity::class.java)
        startActivity(intent)
    }
    fun sonucGoster(){
        val intent=Intent(this@ShowActivity,ResultActivity::class.java)
        intent.putExtra("dogruSayac",dogruSayac)
        startActivity(intent)
        finish()
    }

}