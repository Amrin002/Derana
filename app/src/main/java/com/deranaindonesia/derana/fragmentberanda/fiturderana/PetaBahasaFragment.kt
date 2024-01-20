package com.deranaindonesia.derana.fragmentberanda.fiturderana

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deranaindonesia.derana.R
import com.deranaindonesia.derana.adapter.AdapterListPetaBahasa
import com.deranaindonesia.derana.adapter.ListPetaBahasa

class PetaBahasaFragment : Fragment(R.layout.fragment_fitur_petabahasa) {
    private lateinit var recyclerViewPeta: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewPeta = view.findViewById(R.id.rvPetabahasa)
        val adapter = AdapterListPetaBahasa(itemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Implementasi aksi yang diinginkan saat item diklik
            }
        })
        val layoutManager3 = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)
        recyclerViewPeta.layoutManager = layoutManager3

        recyclerViewPeta.adapter = adapter

        val listKota = dummyListKota()


        adapter.setItems(listKota)

    }

    private fun dummyListKota(): List<ListPetaBahasa> {
        return  listOf(
            ListPetaBahasa(R.drawable.peta_kotaambon, "Kota Ambon", "1 Bahasa"),
            ListPetaBahasa(R.drawable.peta_kotatual, "Kota Tual", "2 Bahasa"),

            )



    }
}
