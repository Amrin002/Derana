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
import com.newderanaindonesia.derana.R
import com.newderanaindonesia.derana.adapter.AdapterActivity
import com.newderanaindonesia.derana.adapter.AdapterBelajar
import com.newderanaindonesia.derana.adapter.AdapterLanguageCard
import com.newderanaindonesia.derana.data.DataActivity
import com.newderanaindonesia.derana.data.DataBelajar
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

        val belajarItems = listOf(
            DataBelajar("Belajar\nBahasa Buru", "Episode 1", R.drawable.belajar1, 50, Color.parseColor("#3CCAFD")),
            DataBelajar("Belajar\nBahasa Alune", "Episode 2", R.drawable.belajar2, 70, Color.parseColor("#DF1995")),
            DataBelajar("Belajar\nBahasa Yatoke", "Episode 3", R.drawable.belajar3, 30, Color.parseColor("#F06400"))
        )

        val activityItems = listOf(
            DataActivity(R.drawable.blue_bg, R.drawable.beach_icon, "Wisata"),
            DataActivity(R.drawable.red_bg,R.drawable.theatere_icon, "Budaya"),
            DataActivity(R.drawable.purple_bg, R.drawable.job_icon, "Pekerjaan"),
            DataActivity(R.drawable.green_bg, R.drawable.food_icon, "Makanan")
        )

        val adapter = AdapterLanguageCard(languageItems)
        binding.rvLanguage.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvLanguage.adapter = adapter
        binding.rvLanguage.addItemDecoration(AdapterLanguageCard.MarginItemDecoration(24))

        val belajarAdapter = AdapterBelajar(belajarItems)
        binding.rvBelajar.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvBelajar.adapter = belajarAdapter

        val adapterActivity = AdapterActivity(activityItems)
        binding.rvActivity.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL, false)
        binding.rvActivity.adapter = adapterActivity
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
