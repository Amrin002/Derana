package com.deranaindonesia.derana.adapter

import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.deranaindonesia.derana.datacontentbelajar.ContentBelajar

class AdapterViewContentBelajar(private val itemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<ContentBelajarHolder>() {

    private val contentBelajarList: MutableList<ContentBelajar> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentBelajarHolder {
        return ContentBelajarHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ContentBelajarHolder, position: Int) {
        holder.bind(contentBelajarList[position])
    }

    override fun getItemCount(): Int {
        return contentBelajarList.size
    }

    fun setItems(items: List<ContentBelajar>) {
        contentBelajarList.clear()
        contentBelajarList.addAll(items)
        notifyDataSetChanged()
    }
}