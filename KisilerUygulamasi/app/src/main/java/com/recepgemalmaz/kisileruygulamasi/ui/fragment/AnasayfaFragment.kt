package com.recepgemalmaz.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.recepgemalmaz.kisileruygulamasi.R
import com.recepgemalmaz.kisileruygulamasi.data.entity.Kisiler
import com.recepgemalmaz.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.recepgemalmaz.kisileruygulamasi.ui.adapter.KisilerAdapter
import com.recepgemalmaz.kisileruygulamasi.ui.viewmodel.AnasayfaViewModel
import com.recepgemalmaz.kisileruygulamasi.utils.gecis
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding

    private lateinit var viewModel: AnasayfaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.rv.layoutManager = LinearLayoutManager(requireContext())
        //binding.rv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        //binding.rv.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)


        viewModel.kisilerListesi.observe(viewLifecycleOwner){
            val kisilerAdapter = KisilerAdapter(requireContext(), it, viewModel)
            binding.rv.adapter = kisilerAdapter
        }


        binding.fab.setOnClickListener {

            Navigation.gecis(it, R.id.kisiKayitFragment)
        }


        binding.searchView.setOnQueryTextListener(object :
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {//Harf Girdikce ve sildikce calisir
                ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {//Arama butonuna basildiginda calisir
                ara(query)
                return false
            }
        })
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun ara(aramaKelimesi: String) {
        viewModel.ara(aramaKelimesi)
    }
    override fun onResume() {
        super.onResume()
        viewModel.kisileriYukle()
    }

}