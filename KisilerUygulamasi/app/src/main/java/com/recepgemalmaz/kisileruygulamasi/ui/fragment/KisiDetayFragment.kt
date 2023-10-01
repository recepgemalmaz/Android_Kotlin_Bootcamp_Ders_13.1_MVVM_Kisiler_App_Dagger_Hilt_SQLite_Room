package com.recepgemalmaz.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.recepgemalmaz.kisileruygulamasi.R
import com.recepgemalmaz.kisileruygulamasi.databinding.FragmentKisiDetayBinding
import com.recepgemalmaz.kisileruygulamasi.ui.viewmodel.AnasayfaViewModel
import com.recepgemalmaz.kisileruygulamasi.ui.viewmodel.KisiDetayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KisiDetayFragment : Fragment() {

    private lateinit var binding: FragmentKisiDetayBinding

    private lateinit var viewModel: KisiDetayViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKisiDetayBinding.inflate(inflater, container, false)

        val bundle:KisiDetayFragmentArgs by navArgs()
        val gelenKisi = bundle.kisi
        binding.editTestKisiAd.setText(gelenKisi.kisi_ad)
        binding.editTextKisiTel.setText(gelenKisi.kisi_tel)

        binding.buttonGuncelle.setOnClickListener {
            val kisi_ad = binding.editTestKisiAd.text.toString()
            val kisi_tel = binding.editTextKisiTel.text.toString()
            guncelle(gelenKisi.kisi_id, kisi_ad, kisi_tel)

        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: KisiDetayViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun guncelle(kisi_id : Int, kisi_ad : String, kisi_tel : String){
        viewModel.guncelle(kisi_id, kisi_ad, kisi_tel)
    }
}