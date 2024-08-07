package com.newderanaindonesia.derana.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.newderanaindonesia.derana.data.DataJenisBelajar
import com.newderanaindonesia.derana.databinding.ItemJenisBelajarBinding


class AdapterJenisBelajar (private val items: List<DataJenisBelajar>) : RecyclerView.Adapter<AdapterJenisBelajar.JenisViewHolder>() {

    class JenisViewHolder(val binding: ItemJenisBelajarBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JenisViewHolder {
        val binding = ItemJenisBelajarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JenisViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JenisViewHolder, position: Int) {
        val item = items[position]
        with(holder.binding) {
            icJenisBelajar.setImageResource(item.iconRes)
            jenisBelajar.text = item.nameJenis
            deskripsiJenis.text = item.deskripsiJenis
        }
    }

    override fun getItemCount() = items.size
}