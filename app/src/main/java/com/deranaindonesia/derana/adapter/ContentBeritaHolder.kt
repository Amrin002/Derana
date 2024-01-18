package com.deranaindonesia.derana.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.deranaindonesia.derana.R

import com.deranaindonesia.derana.datacontent.ContentBerita

class ContentBeritaHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
    private val gambar: ImageView = itemView.findViewById(R.id.gambarberita)
    private val judul: TextView = itemView.findViewById(R.id.judulBerita)
    private val isi : TextView = itemView.findViewById(R.id.isiBerita)


    fun bind(contentBerita: ContentBerita) {

        isi.text = contentBerita.isiBerita
        gambar.setImageResource(contentBerita.gbrBerita)
        judul.text = contentBerita.jdlBerita
    }

    companion object {
        fun create(parent: ViewGroup): ContentBeritaHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_beritaupdate, parent, false)
            return ContentBeritaHolder(view)
        }
    }
}