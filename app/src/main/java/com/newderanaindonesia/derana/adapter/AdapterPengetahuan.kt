package com.newderanaindonesia.derana.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.newderanaindonesia.derana.data.DataPengetahuan
import com.newderanaindonesia.derana.databinding.ItemProdukBinding


class AdapterPengetahuan (private val items: List<DataPengetahuan>) : RecyclerView.Adapter<AdapterPengetahuan.PengetahuanViewHolder>() {

    class PengetahuanViewHolder(val binding: ItemProdukBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PengetahuanViewHolder {
        val binding = ItemProdukBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PengetahuanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PengetahuanViewHolder, position: Int) {
        val item = items[position]
        with(holder.binding) {
            icProduk.setImageResource(item.iconRes)
            txtProduk.text = item.nameProduk



        }
    }

    override fun getItemCount() = items.size
}