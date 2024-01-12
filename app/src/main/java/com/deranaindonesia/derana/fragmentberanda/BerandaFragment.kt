package com.deranaindonesia.derana.fragmentberanda

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.PopupWindow
import com.deranaindonesia.derana.R


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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val popupLayout = view.findViewById<LinearLayout>(R.id.popup_lainnya)//Unresolved reference: popup_lainnya

        //popupLayout.translationY = 1000f


        btnLainnya = view.findViewById(R.id.btnLainnya)
        btnLainnya.setOnClickListener {
            // Animasikan muncul dari bawah
         }

    }

}
