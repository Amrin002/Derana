package com.deranaindonesia.derana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentContainerView
import com.deranaindonesia.derana.fragmentberanda.BerandaFragment
import com.deranaindonesia.derana.fragmentberanda.ChatFragment
import com.deranaindonesia.derana.fragmentberanda.LaporFragment
import com.deranaindonesia.derana.fragmentberanda.StatistikFragment
import com.deranaindonesia.derana.fragmentsignup.FragmentSignupEmail

class BerandaActivity : AppCompatActivity() {
    private lateinit var btnBeranda: Button
    private lateinit var btnStatistik: Button
    private lateinit var btnLapor: Button
    private lateinit var btnChat: Button

    private lateinit var tabFragment: FragmentContainerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)

        tabFragment = findViewById(R.id.tab)
        supportFragmentManager.beginTransaction().replace(R.id.tab, BerandaFragment()).commit()

        btnBeranda = findViewById(R.id.tabBtnBeranda)
        btnBeranda.setOnClickListener{
            tabBeranda()
        }

        btnStatistik = findViewById(R.id.tabbtnStatistik)
        btnStatistik.setOnClickListener {
            tabStatistik()
        }

        btnLapor = findViewById(R.id.tabbtnLapor)
        btnLapor.setOnClickListener {
            tabLapor()
        }
        btnChat = findViewById(R.id.tabbtnChat)
        btnChat.setOnClickListener {
            tabChat()
        }
    }

    private fun tabChat() {
        supportFragmentManager.beginTransaction().replace(R.id.tab, ChatFragment()).commit()

        btnBeranda.setBackgroundResource(R.color.transparansi)
        btnBeranda.setTextColor(resources.getColor(R.color.white))

        btnStatistik.setBackgroundResource(R.color.transparansi)
        btnStatistik.setTextColor(resources.getColor(R.color.white))

        btnLapor.setBackgroundResource(R.color.transparansi)
        btnLapor.setTextColor(resources.getColor(R.color.white))

        btnChat.setBackgroundResource(R.drawable.background_tab_activated)
        btnChat.setTextColor(resources.getColor(R.color.biru))
    }

    private fun tabLapor() {
        supportFragmentManager.beginTransaction().replace(R.id.tab, LaporFragment()).commit()

        btnBeranda.setBackgroundResource(R.color.transparansi)
        btnBeranda.setTextColor(resources.getColor(R.color.white))

        btnStatistik.setBackgroundResource(R.color.transparansi)
        btnStatistik.setTextColor(resources.getColor(R.color.white))

        btnLapor.setBackgroundResource(R.drawable.background_tab_activated)
        btnLapor.setTextColor(resources.getColor(R.color.biru))

        btnChat.setBackgroundResource(R.color.transparansi)
        btnChat.setTextColor(resources.getColor(R.color.white))
    }

    private fun tabStatistik() {
        supportFragmentManager.beginTransaction().replace(R.id.tab, StatistikFragment()).commit()

        btnBeranda.setBackgroundResource(R.color.transparansi)
        btnBeranda.setTextColor(resources.getColor(R.color.white))

        btnStatistik.setBackgroundResource(R.drawable.background_tab_activated)
        btnStatistik.setTextColor(resources.getColor(R.color.biru))

        btnLapor.setBackgroundResource(R.color.transparansi)
        btnLapor.setTextColor(resources.getColor(R.color.white))

        btnChat.setBackgroundResource(R.color.transparansi)
        btnChat.setTextColor(resources.getColor(R.color.white))
    }

    private fun tabBeranda() {
        supportFragmentManager.beginTransaction().replace(R.id.tab, BerandaFragment()).commit()

        btnBeranda.setBackgroundResource(R.drawable.background_tab_activated)
        btnBeranda.setTextColor(resources.getColor(R.color.biru))

        btnStatistik.setBackgroundResource(R.color.transparansi)
        btnStatistik.setTextColor(resources.getColor(R.color.white))

        btnLapor.setBackgroundResource(R.color.transparansi)
        btnLapor.setTextColor(resources.getColor(R.color.white))

        btnChat.setBackgroundResource(R.color.transparansi)
        btnChat.setTextColor(resources.getColor(R.color.white))
    }
}