package com.deranaindonesia.derana.fragmentberanda.fiturderana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import com.deranaindonesia.derana.R
import com.deranaindonesia.derana.fragmentberanda.fiturderana.fragmentkbbi.BahasaFragment
import com.deranaindonesia.derana.fragmentberanda.fiturderana.fragmentkbbi.BidangFragment
import com.deranaindonesia.derana.fragmentberanda.fiturderana.fragmentkbbi.KelasKataFragment
import com.deranaindonesia.derana.fragmentberanda.fiturderana.fragmentkbbi.RagamFragment

class KBBIFragment : Fragment(R.layout.fragment_kbbi) {
    private lateinit var btnKelasKata : TextView
    private lateinit var btnRagam : TextView
    private lateinit var btnBahasa : TextView
    private lateinit var btnBidang : TextView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnKelasKata = view.findViewById(R.id.kelaskata)
        btnKelasKata.setOnClickListener {
            tabKelasKata()
        }
        btnRagam = view.findViewById(R.id.ragam)
        btnRagam.setOnClickListener {
            tabRagam()
        }
        btnBahasa = view.findViewById(R.id.bahasa)
        btnBahasa.setOnClickListener {
            tabBahasa()
        }
        btnBidang = view.findViewById(R.id.bidang)
        btnBidang.setOnClickListener {
            tabBidang()
        }
        tabKelasKata()
    }
    private fun tabKelasKata() {
        replaceFragment(KelasKataFragment())
    }

    private fun tabRagam() {
        replaceFragment(RagamFragment())
    }

    private fun tabBahasa() {
        replaceFragment(BahasaFragment())
    }

    private fun tabBidang() {
        replaceFragment(BidangFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_view_kbbi, fragment)
        transaction.commit()
    }
}