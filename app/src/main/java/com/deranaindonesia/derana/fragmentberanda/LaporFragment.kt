package com.deranaindonesia.derana.fragmentberanda

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentContainerView
import com.deranaindonesia.derana.R
import com.deranaindonesia.derana.fragmentlapor.KategoriFragment

class LaporFragment : Fragment(R.layout.fragment_lapor){

    private lateinit var fcvLapor : FragmentContainerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fcvLapor = view.findViewById(R.id.fcvLapor)

        tampilkanFragment(KategoriFragment())

    }

    private fun tampilkanFragment(fragment: Fragment) {
        val fragmentManager = childFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        // Mengganti kontainer dengan fragment yang diberikan
        fragmentTransaction.replace(R.id.fcvLapor, fragment)

        // Melakukan transaksi
        fragmentTransaction.commit()
    }
}