package com.deranaindonesia.derana.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.deranaindonesia.derana.R
import com.deranaindonesia.derana.datacontent.ContentBelajar

class ContentBelajarHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val idBahasaTextView: TextView = itemView.findViewById(R.id.idBahasa)
    private val idEpisodeTextView: TextView = itemView.findViewById(R.id.idEpisode)
    private val idVideoBelajar : ImageView = itemView.findViewById(R.id.idVideoBelajar)
    private val idBackground : RelativeLayout =itemView.findViewById(R.id.idBackground)
    private val progressBarBelajarVideo: ProgressBar = itemView.findViewById(R.id.progressBarBelajarVideo)

    fun bind(contentBelajar: ContentBelajar) {
        idBahasaTextView.text = contentBelajar.idBahasa
        idEpisodeTextView.text = "Episode ${contentBelajar.idEpisode}"
        idVideoBelajar.setImageResource(contentBelajar.idVideo)
        // Sesuaikan nilai progress sesuai kebutuhan
        progressBarBelajarVideo.progress = contentBelajar.idProgressEpisode
        idBackground.setBackgroundResource(contentBelajar.backgroundDrawableId)
    }

    companion object {
        fun create(parent: ViewGroup): ContentBelajarHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_belajarbahasa, parent, false)
            return ContentBelajarHolder(view)
        }
    }
}
