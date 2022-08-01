package com.ufukgungor.kpssydsapp

class KpssSorular{
        var soru_id: Int?=null
        var soru: String = ""
        var dogru_cevap:String=""
        var bSikki:String=""
        var cSikki:String=""
        var dSikki:String=""
        var eSikki:String=""

        constructor(soru_id: Int,soru:String){
                        this.soru_id=soru_id
                        this.soru=soru
        }
        constructor(dogru_cevap: String,soru_id: Int){
                this.dogru_cevap=dogru_cevap
                this.soru_id=soru_id
        }
        constructor(bSikki:String,cSikki:String,dSikki:String,eSikki:String,soru_id: Int){
                this.bSikki=bSikki
                this.cSikki=cSikki
                this.dSikki=dSikki
                this.eSikki=eSikki
                this.soru_id=soru_id

        }
}
