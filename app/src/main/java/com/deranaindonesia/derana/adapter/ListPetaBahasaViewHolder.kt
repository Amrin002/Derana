package com.deranaindonesia.derana.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.deranaindonesia.derana.R
import com.deranaindonesia.derana.dataclassderana.ListPetaBahasa


class ListPetaBahasaViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
    private val logo: ImageView = itemView.findViewById(R.id.logoPeta)
    private val kota: TextView = itemView.findViewById(R.id.namaKota)
    private val ttlBahasa : TextView = itemView.findViewById(R.id.jumlahBahasa)


    fun bind(listPeta: ListPetaBahasa) {

        logo.setImageResource(listPeta.logoPeta)
        kota.text = listPeta.namaKota
        ttlBahasa.text = listPeta.jumlahBahasa
    }

    companion object {
        fun create(parent: ViewGroup): ListPetaBahasaViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.listpetabahasa, parent, false)
            return ListPetaBahasaViewHolder(view)
        }
    }
}