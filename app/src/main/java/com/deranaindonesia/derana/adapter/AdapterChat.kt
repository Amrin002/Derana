package com.deranaindonesia.derana.adapter

import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.deranaindonesia.derana.datachat.DataChat


class AdapterChat(private val itemClickListener: AdapterView.OnItemClickListener): RecyclerView.Adapter<HolderChat>() {
    private val chatList: MutableList<DataChat> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderChat {
        return HolderChat.create(parent)
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    override fun onBindViewHolder(holder: HolderChat, position: Int) {
        holder.bind(chatList[position])
    }

    fun setItems(items: Collection<DataChat>) {
        chatList.clear()
        chatList.addAll(items)//Type mismatch: inferred type is Collection<HolderChat> but Collection<DataChat> was expected
        notifyDataSetChanged()
    }
}


