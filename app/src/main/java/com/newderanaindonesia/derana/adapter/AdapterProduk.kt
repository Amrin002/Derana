package com.newderanaindonesia.derana.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.newderanaindonesia.derana.data.DataProduk
import com.newderanaindonesia.derana.databinding.ItemProdukBinding


class AdapterProduk (private val items: List<DataProduk>) : RecyclerView.Adapter<AdapterProduk.ProdukViewHolder>() {

    class ProdukViewHolder(val binding: ItemProdukBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdukViewHolder {
        val binding = ItemProdukBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProdukViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProdukViewHolder, position: Int) {
        val item = items[position]
        with(holder.binding) {
            icProduk.setImageResource(item.iconRes)
            txtProduk.text = item.nameProduk



        }
    }

    override fun getItemCount() = items.size
}