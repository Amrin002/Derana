package com.deranaindonesia.derana.adapter

import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.deranaindonesia.derana.dataclassderana.ListPetaBahasa


class AdapterListPetaBahasa(private val itemClickListener: AdapterView.OnItemClickListener): RecyclerView.Adapter<ListPetaBahasaViewHolder>() {
    private val BahasaList: MutableList<ListPetaBahasa> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListPetaBahasaViewHolder {
        return ListPetaBahasaViewHolder.create(parent)
    }

    override fun getItemCount(): Int {
        return BahasaList.size
    }

    override fun onBindViewHolder(holder: ListPetaBahasaViewHolder, position: Int) {
        holder.bind(BahasaList[position])
    }

    fun setItems(items: Collection<ListPetaBahasa>) {
        BahasaList.clear()
        BahasaList.addAll(items)
        notifyDataSetChanged()
    }


}