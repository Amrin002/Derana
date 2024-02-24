package com.deranaindonesia.derana.fragmentberanda


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deranaindonesia.derana.R
import com.deranaindonesia.derana.adapter.AdapterChat
import com.deranaindonesia.derana.datachat.DataChat
import com.deranaindonesia.derana.newchat.NewChatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ChatFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AdapterChat
    private lateinit var btnNewChat : FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chat, container, false)

        recyclerView = view.findViewById(R.id.rvChat)
        adapter = AdapterChat(itemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            // Handle item click here if needed
        })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Sample data
        val chatList = listOf(
            DataChat("A", "Amrin Alamsyah", "Entahlahh", "18/02/24"),
            DataChat("W", "Kaka Wahid", "Ngapain Yah", "19/02/24"),
            DataChat("P", "Mas Pandu", "Intinya Jadi", "17/02/24"),
            // Add more data as needed
        )

        // Set data to the adapter
        adapter.setItems(chatList)

        btnNewChat = view.findViewById(R.id.btnNewChat)
        btnNewChat.setOnClickListener {
            val intent = Intent(requireContext(), NewChatActivity::class.java)
            startActivity(intent)
        }


        return view
    }
}
