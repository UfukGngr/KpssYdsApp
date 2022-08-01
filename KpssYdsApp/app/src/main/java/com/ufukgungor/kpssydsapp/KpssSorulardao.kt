package com.ufukgungor.kpssydsapp

import android.annotation.SuppressLint

class  KpssSorulardao{

    @SuppressLint("Range")
    fun sorularıGetir(vt:VeriTabaniYardimcisi): ArrayList<KpssSorular>{
        val kpssSorularListe=ArrayList<KpssSorular>()
        val db=vt.writableDatabase
        val c=db.rawQuery("SELECT soru_id,soru FROM kpss ORDER BY soru_id LIMIT 5",null)

        while (c.moveToNext()){
            val sorular=KpssSorular(
                c.getInt(c.getColumnIndex("soru_id"))
                ,c.getString(c.getColumnIndex("soru")))
            kpssSorularListe.add(sorular)
        }
        return kpssSorularListe
    }
    @SuppressLint("Range")
    fun dogruCevabıGetir(vt:VeriTabaniYardimcisi): ArrayList<KpssSorular>{
        val kpssSorularListe=ArrayList<KpssSorular>()
        val db=vt.writableDatabase
        val c=db.rawQuery("SELECT dogru_cevap,soru_id FROM kpss ORDER BY soru_id LIMIT 5",null)

        while (c.moveToNext()){
            val dogruCevap=KpssSorular(
                c.getString(c.getColumnIndex("dogru_cevap")),
                c.getInt(c.getColumnIndex("soru_id"))
              )
            kpssSorularListe.add(dogruCevap)
        }
        return kpssSorularListe
    }
    @SuppressLint("Range")
    fun digerSecenekleriGetir(vt:VeriTabaniYardimcisi): ArrayList<KpssSorular>{
        val kpssSorularListe=ArrayList<KpssSorular>()
        val db=vt.writableDatabase
        val c=db.rawQuery("SELECT bSikki,cSikki,dSikki,eSikki,soru_id FROM kpss ORDER BY soru_id LIMIT 5",null)

        while (c.moveToNext()){
            val digerCevaplar=KpssSorular(
                c.getString(c.getColumnIndex("bSikki"))
                ,c.getString(c.getColumnIndex("cSikki"))
                ,c.getString(c.getColumnIndex("dSikki"))
                ,c.getString(c.getColumnIndex("eSikki"))
                ,c.getInt(c.getColumnIndex("soru_id")))
            kpssSorularListe.add(digerCevaplar)
        }
        return kpssSorularListe
    }


     

}