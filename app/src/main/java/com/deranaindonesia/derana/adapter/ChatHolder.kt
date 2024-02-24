package com.deranaindonesia.derana.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.deranaindonesia.derana.R
import com.deranaindonesia.derana.datachat.DataChat


class ChatHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val profilChat: TextView = itemView.findViewById(R.id.iconprofilChat)
    private val kontakChat: TextView = itemView.findViewById(R.id.kontakChat)
    private val isiChat : TextView = itemView.findViewById(R.id.deskChat)
    private val waktuChat : TextView =itemView.findViewById(R.id.timeChat)


    fun bind(dataChat: DataChat) {
        profilChat.text = dataChat.iconProfil
        kontakChat.text = dataChat.kontak
        isiChat.text = dataChat.isiChat
        waktuChat.text = dataChat.waktu


    }

    companion object {
        fun create(parent: ViewGroup): ChatHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.chatview, parent, false)
            return ChatHolder(view)
        }
    }
}