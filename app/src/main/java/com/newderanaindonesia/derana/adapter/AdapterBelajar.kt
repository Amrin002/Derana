package com.newderanaindonesia.derana.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.newderanaindonesia.derana.data.DataBelajar
import com.newderanaindonesia.derana.databinding.ItemBelajarBinding

class AdapterBelajar (private val items: List<DataBelajar>) : RecyclerView.Adapter<AdapterBelajar.BelajarViewHolder>() {

    class BelajarViewHolder(val binding: ItemBelajarBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BelajarViewHolder {
        val binding = ItemBelajarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BelajarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BelajarViewHolder, position: Int) {
        val item = items[position]
        with(holder.binding) {
            judulBelajar.text = item.title
            episodeBelajar.text = item.episode
            imgBelajar.setImageResource(item.imageRes)
            progressBar.progress = item.progress
            (root as MaterialCardView).setCardBackgroundColor(item.backgroundColor)
        }
    }

    override fun getItemCount() = items.size
}