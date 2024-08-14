package com.newderanaindonesia.derana.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.newderanaindonesia.derana.R
import com.newderanaindonesia.derana.adapter.AdapterBelajar
import com.newderanaindonesia.derana.data.DataBelajar
import com.newderanaindonesia.derana.databinding.FragmentHomeBinding
import com.newderanaindonesia.derana.fragments.features.VitalitasBahasaFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val belajarItems = listOf(
            DataBelajar("Belajar\nBahasa Buru", "Episode 1", R.drawable.belajar1, 50, Color.parseColor("#3CCAFD")),
            DataBelajar("Belajar\nBahasa Alune", "Episode 2", R.drawable.belajar2, 70, Color.parseColor("#DF1995")),
            DataBelajar("Belajar\nBahasa Yatoke", "Episode 3", R.drawable.belajar3, 30, Color.parseColor("#F06400"))
        )

        val adapter = AdapterBelajar(belajarItems)
        binding.rvBelajar.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvBelajar.adapter = adapter

        binding.connectAccount.setOnClickListener {
            //
        }

//        fitur derana
        binding.BtnKamusbahasa.setOnClickListener {
            //
        }

        binding.BtnPenerjemaah.setOnClickListener {
            //
        }
        binding.BtnDatabahasa.setOnClickListener {
            //
        }
        binding.BtnPetabahasa.setOnClickListener {
            //
        }
        binding.BtnVitalitasbahasa.setOnClickListener {

            val vitalitasBahasaFragment = VitalitasBahasaFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, vitalitasBahasaFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.BtnVideobahasa.setOnClickListener {
            //
        }
        binding.BtnBukudigital.setOnClickListener {
            //
        }
        binding.BtnLainnya.setOnClickListener {
            // BUAT LOGIKA SAAT USER KLIK FITUR LAINNYA MAKA MUNCUL BOTTOM SHEET YANG SUDAH DI BUAT
            val bottomSheet = AllProduk()
            bottomSheet.show(parentFragmentManager, "ProdukBottomSheetFragment")

        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}