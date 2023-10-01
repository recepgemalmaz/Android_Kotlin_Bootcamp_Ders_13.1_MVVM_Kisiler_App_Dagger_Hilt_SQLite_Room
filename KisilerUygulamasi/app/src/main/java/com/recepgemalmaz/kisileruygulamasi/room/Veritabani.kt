package com.recepgemalmaz.kisileruygulamasi.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.recepgemalmaz.kisileruygulamasi.data.entity.Kisiler


@Database(entities = [Kisiler::class], version = 1)
abstract class Veritabani : RoomDatabase(){
    abstract fun getKisilerDao() : KisilerDao
}