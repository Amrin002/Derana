package com.deranaindonesia.derana.adapter

import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.deranaindonesia.derana.datacontent.ContentBerita

class AdapterContentBerita(private val itemClickListener: OnItemClickListener): RecyclerView.Adapter<ContentBeritaHolder>() {
    private val contentBeritaList: MutableList<ContentBerita> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentBeritaHolder {
        return ContentBeritaHolder.create(parent)
    }

    override fun getItemCount(): Int {
       return contentBeritaList.size
    }

    override fun onBindViewHolder(holder: ContentBeritaHolder, position: Int) {
        holder.bind(contentBeritaList[position])
    }

    fun setItems1(items1: Collection<ContentBerita>) {
        contentBeritaList.clear()
        contentBeritaList.addAll(items1)
        notifyDataSetChanged()
    }


}