package com.newderanaindonesia.derana.fragments

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.newderanaindonesia.derana.adapter.AdapterLanguageCard
import com.newderanaindonesia.derana.data.DataLanguageCard
import com.newderanaindonesia.derana.databinding.FragmentDiscoverBinding

class DiscoverFragment : Fragment() {

    private var _binding: FragmentDiscoverBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        _binding = FragmentDiscoverBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val languageItems = listOf(
            DataLanguageCard("Bahasa Alune", Color.parseColor("#3CCAFD")),
            DataLanguageCard("Bahasa Ambalau", Color.parseColor("#FF8500")),
             DataLanguageCard("Bahasa Buru", Color.parseColor("#FF53BF"))
        )

        val adapter = AdapterLanguageCard(languageItems)
        binding.rvLanguage.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvLanguage.adapter = adapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
