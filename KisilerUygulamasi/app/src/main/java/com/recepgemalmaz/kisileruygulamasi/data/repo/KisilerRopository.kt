package com.recepgemalmaz.kisileruygulamasi.data.repo

import android.util.Log
import com.recepgemalmaz.kisileruygulamasi.data.datasource.KisilerDataSources
import com.recepgemalmaz.kisileruygulamasi.data.entity.Kisiler

class KisilerRopository(var kds : KisilerDataSources) {


    suspend fun kaydet(kisi_Ad : String, kisi_Tel : String) = kds.kaydet(kisi_Ad, kisi_Tel)

    suspend fun guncelle(kisi_id : Int, kisi_ad : String, kisi_tel : String) = kds.guncelle(kisi_id, kisi_ad, kisi_tel)

    suspend fun sil(kisi_id : Int) = kds.sil(kisi_id)

    suspend fun kisileriYukle(): List<Kisiler> = kds.kisileriYukle()

    suspend fun ara(aramaKelimesi: String): List<Kisiler> = kds.ara(aramaKelimesi)
}
