package com.deranaindonesia.derana.fragmentberanda.fiturderana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import com.deranaindonesia.derana.R
import com.deranaindonesia.derana.fragmentberanda.fiturderana.fragmentsiniarbahasa.BahasaFragment
import com.deranaindonesia.derana.fragmentberanda.fiturderana.fragmentsiniarbahasa.ForyouFragment
import com.deranaindonesia.derana.fragmentberanda.fiturderana.fragmentsiniarbahasa.KebudayaanFragment
import com.deranaindonesia.derana.fragmentberanda.fiturderana.fragmentsiniarbahasa.LinguistikFragment
import com.deranaindonesia.derana.fragmentberanda.fiturderana.fragmentsiniarbahasa.SastraFragment

class SiniarBahasaFragment : Fragment(R.layout.fragment_siniarbahasa) {
    private lateinit var btnUntukkamu : TextView
    private lateinit var btnSBbahasa : TextView
    private lateinit var btnSBsastra : TextView
    private lateinit var btnSBlinguistik : TextView
    private lateinit var btnSBkebudayaan : TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnUntukkamu = view.findViewById(R.id.SBForyou)
        btnUntukkamu.setOnClickListener {
            tabforyou()
        }
        btnSBbahasa = view.findViewById(R.id.SBbahasa)
        btnSBbahasa.setOnClickListener {
            tabbahasa()
        }
        btnSBkebudayaan = view.findViewById(R.id.SBkebudayaan)
        btnSBkebudayaan.setOnClickListener {
            tabkebudayaan()
        }
        btnSBsastra = view.findViewById(R.id.SBsastra)
        btnSBsastra.setOnClickListener {
            tabsastra()
        }
        btnSBlinguistik = view.findViewById(R.id.SBlinguistik)
        btnSBlinguistik.setOnClickListener {
            tablinguistik()
        }
        tabforyou()
    }

    private fun tabforyou() {
        replaceFragment(ForyouFragment())
        btnUntukkamu.setTextColor(resources.getColor(R.color.black))
        btnUntukkamu.setBackgroundResource(R.drawable.bg_tabkbbiactivated)

        btnSBbahasa.setTextColor(resources.getColor(R.color.tabkbbinotactivated))
        btnSBbahasa.setBackgroundResource(R.color.transparansi)
        btnSBsastra.setTextColor(resources.getColor(R.color.tabkbbinotactivated))
        btnSBsastra.setBackgroundResource(R.color.transparansi)
        btnSBlinguistik.setTextColor(resources.getColor(R.color.tabkbbinotactivated))
        btnSBlinguistik.setBackgroundResource(R.color.transparansi)
        btnSBkebudayaan.setTextColor(resources.getColor(R.color.tabkbbinotactivated))
        btnSBkebudayaan.setBackgroundResource(R.color.transparansi)
    }

    private fun tabbahasa() {
        replaceFragment(BahasaFragment())
        btnSBbahasa.setTextColor(resources.getColor(R.color.black))
        btnSBbahasa.setBackgroundResource(R.drawable.bg_tabkbbiactivated)

        btnUntukkamu.setTextColor(resources.getColor(R.color.tabkbbinotactivated))
        btnUntukkamu.setBackgroundResource(R.color.transparansi)
        btnSBsastra.setTextColor(resources.getColor(R.color.tabkbbinotactivated))
        btnSBsastra.setBackgroundResource(R.color.transparansi)
        btnSBlinguistik.setTextColor(resources.getColor(R.color.tabkbbinotactivated))
        btnSBlinguistik.setBackgroundResource(R.color.transparansi)
        btnSBkebudayaan.setTextColor(resources.getColor(R.color.tabkbbinotactivated))
        btnSBkebudayaan.setBackgroundResource(R.color.transparansi)
    }

    private fun tabsastra() {
        replaceFragment(SastraFragment())
        btnSBsastra.setTextColor(resources.getColor(R.color.black))
        btnSBsastra.setBackgroundResource(R.drawable.bg_tabkbbiactivated)

        btnUntukkamu.setTextColor(resources.getColor(R.color.tabkbbinotactivated))
        btnUntukkamu.setBackgroundResource(R.color.transparansi)
        btnSBbahasa.setTextColor(resources.getColor(R.color.tabkbbinotactivated))
        btnSBbahasa.setBackgroundResource(R.color.transparansi)
        btnSBlinguistik.setTextColor(resources.getColor(R.color.tabkbbinotactivated))
        btnSBlinguistik.setBackgroundResource(R.color.transparansi)
        btnSBkebudayaan.setTextColor(resources.getColor(R.color.tabkbbinotactivated))
        btnSBkebudayaan.setBackgroundResource(R.color.transparansi)
    }

    private fun tablinguistik() {
        replaceFragment(LinguistikFragment())
        btnSBlinguistik.setTextColor(resources.getColor(R.color.black))
        btnSBlinguistik.setBackgroundResource(R.drawable.bg_tabkbbiactivated)

        btnUntukkamu.setTextColor(resources.getColor(R.color.tabkbbinotactivated))
        btnUntukkamu.setBackgroundResource(R.color.transparansi)
        btnSBbahasa.setTextColor(resources.getColor(R.color.tabkbbinotactivated))
        btnSBbahasa.setBackgroundResource(R.color.transparansi)
        btnSBsastra.setTextColor(resources.getColor(R.color.tabkbbinotactivated))
        btnSBsastra.setBackgroundResource(R.color.transparansi)
        btnSBkebudayaan.setTextColor(resources.getColor(R.color.tabkbbinotactivated))
        btnSBkebudayaan.setBackgroundResource(R.color.transparansi)
    }

    private fun tabkebudayaan() {
        replaceFragment(KebudayaanFragment())
        btnSBkebudayaan.setTextColor(resources.getColor(R.color.black))
        btnSBkebudayaan.setBackgroundResource(R.drawable.bg_tabkbbiactivated)

        btnUntukkamu.setTextColor(resources.getColor(R.color.tabkbbinotactivated))
        btnUntukkamu.setBackgroundResource(R.color.transparansi)
        btnSBbahasa.setTextColor(resources.getColor(R.color.tabkbbinotactivated))
        btnSBbahasa.setBackgroundResource(R.color.transparansi)
        btnSBsastra.setTextColor(resources.getColor(R.color.tabkbbinotactivated))
        btnSBsastra.setBackgroundResource(R.color.transparansi)
        btnSBlinguistik.setTextColor(resources.getColor(R.color.tabkbbinotactivated))
        btnSBlinguistik.setBackgroundResource(R.color.transparansi)
    }
    private fun replaceFragment(fragment: Fragment) {
        val transaction : FragmentTransaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.fcvSiniarbahasa,fragment)
        transaction.commit()
    }
}