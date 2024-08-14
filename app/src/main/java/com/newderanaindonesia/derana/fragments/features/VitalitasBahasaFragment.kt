package com.newderanaindonesia.derana.fragments.features

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.newderanaindonesia.derana.R
import com.newderanaindonesia.derana.adapter.AdapterProvinsi
import com.newderanaindonesia.derana.data.DataProvinsi
import com.newderanaindonesia.derana.databinding.FragmentVitalitasBahasaBinding


class VitalitasBahasaFragment : Fragment() {
    private var _binding: FragmentVitalitasBahasaBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentVitalitasBahasaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pulauItems = listOf(
            DataProvinsi(R.drawable.logojogja, "DKI Jakarta", "Jawa"),
            DataProvinsi(R.drawable.logojogja, "DKI Jakarta", "Jawa"),
            DataProvinsi(R.drawable.logojogja, "DKI Jakarta", "Jawa"),
            DataProvinsi(R.drawable.logojogja, "DKI Jakarta", "Jawa"),
            DataProvinsi(R.drawable.logojogja, "DKI Jakarta", "Jawa"),
            DataProvinsi(R.drawable.logojogja, "DKI Jakarta", "Jawa"),
        )



        val adapterBahasa = AdapterProvinsi(pulauItems)
        binding.rvProvinsi.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvProvinsi.adapter = adapterBahasa
    }


}