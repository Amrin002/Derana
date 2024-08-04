package com.newderanaindonesia.derana.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.newderanaindonesia.derana.data.DataActivity
import com.newderanaindonesia.derana.databinding.ItemCommunityActivityBinding

class AdapterActivity(private val items: List<DataActivity>) : RecyclerView.Adapter<AdapterActivity.ActivityViewHolder>() {

    class ActivityViewHolder(val binding: ItemCommunityActivityBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val binding = ItemCommunityActivityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ActivityViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        val item = items[position]
        val context = holder.itemView.context
        val drawable = ContextCompat.getDrawable(context, item.imageBgRes)
        with(holder.binding) {
            bgActivity.background = drawable
            image.setImageResource(item.imageRes)
            communityText.text = item.text
        }
    }
}
