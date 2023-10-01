package com.recepgemalmaz.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels

import com.recepgemalmaz.kisileruygulamasi.R
import com.recepgemalmaz.kisileruygulamasi.databinding.FragmentKisiKayitBinding
import com.recepgemalmaz.kisileruygulamasi.ui.viewmodel.AnasayfaViewModel
import com.recepgemalmaz.kisileruygulamasi.ui.viewmodel.KisiKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KisiKayitFragment : Fragment() {

    private lateinit var binding: FragmentKisiKayitBinding

    private lateinit var viewModel: KisiKayitViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentKisiKayitBinding.inflate(inflater, container, false)

        binding.buttonKaydet.setOnClickListener {
            val kisi_ad = binding.editTestKisiAd.text.toString()
            val kisi_tel = binding.editTextKisiTel.text.toString()
            kaydet(kisi_ad, kisi_tel)
        }
        return binding.root

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: KisiKayitViewModel by viewModels()
        viewModel = tempViewModel
    }


    fun kaydet(kisi_Ad : String, kisi_Tel : String){

        viewModel.kaydet(kisi_Ad, kisi_Tel)

    }
}