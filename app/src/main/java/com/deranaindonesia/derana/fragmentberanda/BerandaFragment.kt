package com.deranaindonesia.derana.fragmentberanda

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.View
import android.widget.AdapterView

import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.deranaindonesia.derana.R
import com.deranaindonesia.derana.adapter.AdapterContentBerita
import com.deranaindonesia.derana.adapter.AdapterViewContentBelajar
import com.deranaindonesia.derana.datacontent.ContentBelajar
import com.deranaindonesia.derana.datacontent.ContentBerita
import com.deranaindonesia.derana.fragmentberanda.berandabottomsheet.FiturBottomSheet
import com.deranaindonesia.derana.fragmentberanda.fiturderana.KBBIFragment
import com.deranaindonesia.derana.fragmentberanda.fiturderana.KamusBahasaFragment
import com.deranaindonesia.derana.fragmentberanda.fiturderana.PetaBahasaFragment


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
    private lateinit var rvBerita : RecyclerView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        btnLainnya = view.findViewById(R.id.btnLainnya)
        btnLainnya.setOnClickListener {
            val bottomSheetFragment = FiturBottomSheet()
            bottomSheetFragment.show(parentFragmentManager, bottomSheetFragment.tag)
        }

        btnProfil = view.findViewById(R.id.profilUser)



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

        btnKBBI = view.findViewById(R.id.btnKBBI)
        btnKBBI.setOnClickListener {
            openKBBIFragment()
        }

        btnPetaBahasa = view.findViewById(R.id.btnPetaBahasa)
        btnPetaBahasa.setOnClickListener{
            openPetaBahasaFragment()
        }

        btnKamusBahasa = view.findViewById(R.id.btnKamusBahasa)
        btnKamusBahasa.setOnClickListener {
            openKamusBahasaFragment()
        }


        // Set the adapter to the RecyclerView
        rvVideoBelajar.adapter = adapter
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvVideoBelajar.layoutManager = layoutManager

        adapter.setItems(contentList)



        rvBerita = view.findViewById(R.id.rvBerita)
        val layoutManagerberita =  LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val adapter1 = AdapterContentBerita(itemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Implementasi aksi yang diinginkan saat item diklik
            }
        })
        rvBerita.adapter = adapter1

        rvBerita.layoutManager = layoutManagerberita
        val contentlistBerita = generateSampleContentBerita()

        adapter1.setItems1(contentlistBerita)


    }

    private fun openKamusBahasaFragment() {
        val fragmentManager : FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val kamusbahasaFragment = KamusBahasaFragment()
        fragmentTransaction.replace(R.id.tab, kamusbahasaFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun openPetaBahasaFragment() {
        val fragmentManager : FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val petabahasaFragment = PetaBahasaFragment()
        fragmentTransaction.replace(R.id.tab, petabahasaFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun openKBBIFragment() {
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        // Replace the current fragment with KBBIFragment
        val kbbiFragment = KBBIFragment()
        fragmentTransaction.replace(R.id.tab, kbbiFragment)
        fragmentTransaction.addToBackStack(null) // Add to back stack for back navigation
        fragmentTransaction.commit()
    }

    private fun generateSampleContentBerita(): List<ContentBerita> {
        return listOf(
            ContentBerita(R.drawable.paknadim, "Generasi Muda Unggul Kunci Kemajuan Bangsa", "Peringatan Hari Anak Nasional (HAN) 2022 menjadi salah satu agenda dalam acara..."),
            ContentBerita(R.drawable.paknadim2, "Kemdikbudristek Dukung Digitalisasi Pendidikan", "Kementerian Pendidikan, Kebudayaan, Riset, dan Teknologi (Kemendikbudristek)...")
        )

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
