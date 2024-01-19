package com.deranaindonesia.derana.fragmentberanda.fiturderana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.Spinner
import com.deranaindonesia.derana.R

class KamusBahasaFragment : Fragment(R.layout.fragment_fitur_kamusbahasa) {
    private lateinit var btnSwitchLang: ImageButton

    private val options = arrayOf("Indonesia", "Seram", "Asilulu")
    private val options2 = arrayOf("Asilulu", "Seram", "Indonesia")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSwitchLang = view.findViewById(R.id.btnSwitchLang)

        // Spinner 1
        val spinner1: Spinner = view.findViewById(R.id.translate1)
        val adapter1 = ArrayAdapter(requireContext(), R.layout.bahasa_translate, options)
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner1.adapter = adapter1

        // Spinner 2
        val spinner2: Spinner = view.findViewById(R.id.translate2)
        val adapter2 = ArrayAdapter(requireContext(), R.layout.bahasa_translate, options2)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner2.adapter = adapter2

        // ImageButton onClickListener
        btnSwitchLang.setOnClickListener {
            // Simpan item yang dipilih di setiap Spinner
            val selectedItem1 = spinner1.selectedItem
            val selectedItem2 = spinner2.selectedItem

            // Tukar item yang dipilih di dalam Spinner 1 dan Spinner 2
            spinner1.setSelection(options2.indexOf(selectedItem2))
            spinner2.setSelection(options.indexOf(selectedItem1))
        }
    }
}

