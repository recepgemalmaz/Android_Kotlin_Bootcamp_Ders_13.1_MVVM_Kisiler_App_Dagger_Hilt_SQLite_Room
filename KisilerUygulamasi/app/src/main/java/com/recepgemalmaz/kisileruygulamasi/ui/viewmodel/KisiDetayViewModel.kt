package com.recepgemalmaz.kisileruygulamasi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.recepgemalmaz.kisileruygulamasi.data.repo.KisilerRopository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KisiDetayViewModel@Inject constructor(var krepo: KisilerRopository): ViewModel(){


    fun guncelle(kisi_id : Int, kisi_ad : String, kisi_tel : String){
        CoroutineScope(Dispatchers.Main).launch {
            krepo.guncelle(kisi_id, kisi_ad, kisi_tel)
        }
    }
}