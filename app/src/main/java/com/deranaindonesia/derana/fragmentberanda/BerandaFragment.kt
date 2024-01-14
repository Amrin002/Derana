package com.deranaindonesia.derana.fragmentberanda

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.View
import android.widget.AdapterView

import android.widget.EditText
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.deranaindonesia.derana.R
import com.deranaindonesia.derana.adapter.AdapterViewContentBelajar
import com.deranaindonesia.derana.datacontentbelajar.ContentBelajar



class BerandaFragment : Fragment(R.layout.fragment_beranda) {

    private lateinit var btnProfil : ImageButton
    private lateinit var etSearchBeranda : EditText
    private lateinit var btnKBBI : ImageButton
    private lateinit var btnKamusBahasa : ImageButton
    private lateinit var btnDataBahasa : ImageButton
    private lateinit var btnPetaBahasa : ImageButton
    private lateinit var btnVitalitasBahasa : ImageButton
    private lateinit var btnSiniarBahasa : ImageButton
    private lateinit var btnBukuDigital : ImageButton
    private lateinit var btnLainnya : ImageButton
    private lateinit var rvVideoBelajar : RecyclerView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btnLainnya = view.findViewById(R.id.btnLainnya)
        btnLainnya.setOnClickListener {
            // set klik nya
         }

        // Initialize RecyclerView
        rvVideoBelajar = view.findViewById(R.id.rvVideoBelajar)

        // Create a list of sample content for the RecyclerView
        val contentList = generateSampleContent()

        // Create and set up the adapter
        val adapter = AdapterViewContentBelajar(itemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Implementasi aksi yang diinginkan saat item diklik
            }
        })



        // Set the adapter to the RecyclerView
        rvVideoBelajar.adapter = adapter
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvVideoBelajar.layoutManager = layoutManager

        adapter.setItems(contentList)

    }



    private fun generateSampleContent(): List<ContentBelajar> {
        // Generate and return sample content for testing
        return listOf(
            ContentBelajar("Bahasa Buru", "1", 20, R.drawable.profilcontentvideo1, R.drawable.background_contentbelajar,),
            ContentBelajar("Bahasa Sunda", "3", 40, R.drawable.profilcontentvideo2, R.drawable.background_contentbelajar2),
            // Add more sample content as needed
        )
    }

}
