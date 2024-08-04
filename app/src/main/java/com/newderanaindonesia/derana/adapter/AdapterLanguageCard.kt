package com.newderanaindonesia.derana.adapter

import android.graphics.Color
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newderanaindonesia.derana.data.DataLanguageCard
import com.newderanaindonesia.derana.databinding.ItemBelajarBinding
import com.newderanaindonesia.derana.databinding.ItemLanguageCardBinding

class AdapterLanguageCard(private val items: List<DataLanguageCard>) : RecyclerView.Adapter<AdapterLanguageCard.ViewLanguageCardHolder>() {
    class ViewLanguageCardHolder(val binding: ItemLanguageCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewLanguageCardHolder {
        val binding = ItemLanguageCardBinding.inflate(LayoutInflater.from(parent.context))
        return ViewLanguageCardHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewLanguageCardHolder, position: Int) {
        val item = items[position]
        with(holder.binding){
            languageName.text = item.languageName
            color.setBackgroundColor(item.color)
        }
    }

    override fun getItemCount() = items.size

    class MarginItemDecoration(private val spaceHeight: Int) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            outRect.right = spaceHeight
        }
    }
}