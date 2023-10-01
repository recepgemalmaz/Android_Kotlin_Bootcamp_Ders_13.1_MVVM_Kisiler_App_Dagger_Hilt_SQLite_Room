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
class KisiKayitViewModel @Inject constructor(var krepo: KisilerRopository): ViewModel(){


    fun kaydet(kisi_Ad : String, kisi_Tel : String){
        CoroutineScope(Dispatchers.Main).launch {
            krepo.kaydet(kisi_Ad, kisi_Tel)
        }

    }
}