package com.ufukgungor.kpssydsapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class VeriTabaniYardimcisi(context: Context)
    : SQLiteOpenHelper(context,"kpssSorular.db",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
       db?.execSQL("CREATE TABLE IF NOT EXISTS \"kpss\" (\n" +
               "\t\"soru_id\"\tINTEGER,\n" +
               "\t\"soru\"\tTEXT,\n" +
               "\t\"dogru_cevap\"\tTEXT,\n" +
               "\t\"bSikki\"\tTEXT,\n" +
               "\t\"cSikki\"\tTEXT,\n" +
               "\t\"dSikki\"\tTEXT,\n" +
               "\t\"eSikki\"\tTEXT\n" +
               ");")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS kpss")
        onCreate(db)
    }
}