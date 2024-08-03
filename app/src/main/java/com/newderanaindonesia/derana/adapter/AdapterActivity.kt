package com.newderanaindonesia.derana.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newderanaindonesia.derana.data.DataActivity
import com.newderanaindonesia.derana.databinding.ItemCommunityActivityBinding

class AdapterActivity(private val items: List<DataActivity>) : RecyclerView.Adapter<AdapterActivity.ActivityViewHolder>() {
    class ActivityViewHolder(val binding: ItemCommunityActivityBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}