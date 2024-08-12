package com.newderanaindonesia.derana.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.newderanaindonesia.derana.data.DataProvinsi
import com.newderanaindonesia.derana.databinding.ItemBahasaBinding


class AdapterProvinsi (private val items: List<DataProvinsi>) : RecyclerView.Adapter<AdapterProvinsi.ProvinsiViewHolder>() {

    class ProvinsiViewHolder(val binding: ItemBahasaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinsiViewHolder {
        val binding = ItemBahasaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProvinsiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProvinsiViewHolder, position: Int) {
        val item = items[position]
        with(holder.binding) {
            logoProv.setImageResource(item.iconRes)
            namaProv.text = item.nameProvinsi
            namaPulau.text = item.pulau
        }
    }

    override fun getItemCount() = items.size
}