package com.newderanaindonesia.derana.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.newderanaindonesia.derana.R
import com.newderanaindonesia.derana.R.drawable.ic_grid_selector
import com.newderanaindonesia.derana.R.drawable.ic_linear_selector
import com.newderanaindonesia.derana.adapter.AdapterPengetahuan
import com.newderanaindonesia.derana.adapter.AdapterProduk
import com.newderanaindonesia.derana.data.DataPengetahuan
import com.newderanaindonesia.derana.data.DataProduk
import com.newderanaindonesia.derana.databinding.AllFiturBinding

class AllProduk: BottomSheetDialogFragment() {
    private var _binding: AllFiturBinding? = null
    private val binding get() = _binding!!
    private var isGrid = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AllFiturBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val produkItems = listOf(
            DataProduk(R.drawable.ar_bahasa, "AR\nBahasa"),
            DataProduk(R.drawable.statistik_bahasa, "Statiskit\nBahasa"),
            DataProduk(R.drawable.kartu_bahasa, "Kartu\nBahasa")

        )
        val adapter = AdapterProduk(produkItems)
        binding.rvProduk.layoutManager = GridLayoutManager(context, 3)
        binding.rvProduk.adapter = adapter

        val pengetahuanItems = listOf(
            DataPengetahuan(R.drawable.kekerabatan_bahasa, "Kekerabatan\nBahasa"),
            DataPengetahuan(R.drawable.kosakata_swedesh, "Kosakata\nSwedesh")


        )
        val adapter1 = AdapterPengetahuan(pengetahuanItems)
        binding.rvPengatahuan.layoutManager = GridLayoutManager(context, 3)
        binding.rvPengatahuan.adapter = adapter1

        binding.icGridView.setOnClickListener {
            if (!isGrid) {
                binding.rvProduk.layoutManager = GridLayoutManager(context, 3)
                binding.rvPengatahuan.layoutManager = GridLayoutManager(context, 3)
                isGrid = true
                updateViewMode(isGrid)
            }
        }

        binding.icLinearView.setOnClickListener {
            if (isGrid) {
                binding.rvProduk.layoutManager = LinearLayoutManager(context)
                binding.rvPengatahuan.layoutManager = LinearLayoutManager(context)
                isGrid = false
                updateViewMode(isGrid)
            }

        }

    }
    private fun updateViewMode(isGrid: Boolean) {
        if (isGrid) {
            binding.icGridView.setBackgroundResource(ic_grid_selector)
            binding.icGridView.setColorFilter(ContextCompat.getColor(requireContext(), R.color.blue), android.graphics.PorterDuff.Mode.SRC_IN)
            binding.icLinearView.setBackgroundResource(ic_linear_selector)
            binding.icLinearView.clearColorFilter()
        } else {
            binding.icGridView.setBackgroundResource(ic_grid_selector)
            binding.icGridView.clearColorFilter()
            binding.icLinearView.setBackgroundResource(ic_linear_selector)
            binding.icLinearView.setColorFilter(ContextCompat.getColor(requireContext(), R.color.blue), android.graphics.PorterDuff.Mode.SRC_IN)
        }
    }


        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }