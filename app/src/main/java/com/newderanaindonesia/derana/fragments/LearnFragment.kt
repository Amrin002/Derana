package com.newderanaindonesia.derana.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.newderanaindonesia.derana.R
import com.newderanaindonesia.derana.adapter.AdapterJenisBelajar
import com.newderanaindonesia.derana.adapter.AdapterProvinsi
import com.newderanaindonesia.derana.data.DataJenisBelajar
import com.newderanaindonesia.derana.data.DataProvinsi
import com.newderanaindonesia.derana.databinding.FragmentLearnBinding

class LearnFragment : Fragment() {

    private var _binding: FragmentLearnBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLearnBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pulauItems = listOf(
            DataProvinsi(R.drawable.logojogja, "DKI Jakarta", "Jawa"),
        )
        val jenisBelajarItems = listOf(
            DataJenisBelajar(R.drawable.ic_audio, "Audio", "Pelajari bunyi fonem bahasa daerah"),
        )


        val adapterBahasa = AdapterProvinsi(pulauItems)
        binding.rvProvinsi.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvProvinsi.adapter = adapterBahasa

        val adapterJenisBelajar = AdapterJenisBelajar(jenisBelajarItems)
        binding.rvJenisBelajar.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.rvJenisBelajar.adapter = adapterJenisBelajar
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}