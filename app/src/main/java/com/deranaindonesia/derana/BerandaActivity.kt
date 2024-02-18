package com.deranaindonesia.derana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentContainerView
import com.deranaindonesia.derana.databinding.ActivityBerandaBinding
import com.deranaindonesia.derana.fragmentberanda.BerandaFragment
import com.deranaindonesia.derana.fragmentberanda.ChatFragment
import com.deranaindonesia.derana.fragmentberanda.LaporFragment
import com.deranaindonesia.derana.fragmentberanda.StatistikFragment
import com.deranaindonesia.derana.fragmentsignup.FragmentSignupEmail

class BerandaActivity : AppCompatActivity() {
    private lateinit var binding : ActivityBerandaBinding

    private lateinit var tabFragment: FragmentContainerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBerandaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tabFragment = findViewById(R.id.tab)
        supportFragmentManager.beginTransaction().replace(R.id.tab, BerandaFragment()).commit()


        binding.tabBtnBeranda.setOnClickListener{
            tabBeranda()
        }


        binding.tabbtnStatistik.setOnClickListener {
            tabStatistik()
        }


        binding.tabbtnLapor.setOnClickListener {
            tabLapor()
        }

        binding.tabbtnChat.setOnClickListener {
            tabChat()
        }
    }

    private fun tabChat() {
        supportFragmentManager.beginTransaction().replace(R.id.tab, ChatFragment()).commit()

        binding.tabBtnBeranda.setBackgroundResource(R.color.transparansi)
        binding.tabBtnBeranda.setTextColor(resources.getColor(R.color.white))

        binding.tabbtnStatistik.setBackgroundResource(R.color.transparansi)
        binding.tabbtnStatistik.setTextColor(resources.getColor(R.color.white))

        binding.tabbtnLapor.setBackgroundResource(R.color.transparansi)
        binding.tabbtnLapor.setTextColor(resources.getColor(R.color.white))

        binding.tabbtnChat.setBackgroundResource(R.drawable.background_tab_activated)
        binding.tabbtnChat.setTextColor(resources.getColor(R.color.primary))
    }

    private fun tabLapor() {
        supportFragmentManager.beginTransaction().replace(R.id.tab, LaporFragment()).commit()

        binding.tabBtnBeranda.setBackgroundResource(R.color.transparansi)
        binding.tabBtnBeranda.setTextColor(resources.getColor(R.color.white))

        binding.tabbtnStatistik.setBackgroundResource(R.color.transparansi)
        binding.tabbtnStatistik.setTextColor(resources.getColor(R.color.white))

        binding.tabbtnLapor.setBackgroundResource(R.drawable.background_tab_activated)
        binding.tabbtnLapor.setTextColor(resources.getColor(R.color.primary))

        binding.tabbtnChat.setBackgroundResource(R.color.transparansi)
        binding.tabbtnChat.setTextColor(resources.getColor(R.color.white))
    }

    private fun tabStatistik() {
        supportFragmentManager.beginTransaction().replace(R.id.tab, StatistikFragment()).commit()

        binding.tabBtnBeranda.setBackgroundResource(R.color.transparansi)
        binding.tabBtnBeranda.setTextColor(resources.getColor(R.color.white))

        binding.tabbtnStatistik.setBackgroundResource(R.drawable.background_tab_activated)
        binding.tabbtnStatistik.setTextColor(resources.getColor(R.color.primary))

        binding.tabbtnLapor.setBackgroundResource(R.color.transparansi)
        binding.tabbtnLapor.setTextColor(resources.getColor(R.color.white))

        binding.tabbtnChat.setBackgroundResource(R.color.transparansi)
        binding.tabbtnChat.setTextColor(resources.getColor(R.color.white))
    }

    private fun tabBeranda() {
        supportFragmentManager.beginTransaction().replace(R.id.tab, BerandaFragment()).commit()

       binding.tabBtnBeranda.setBackgroundResource(R.drawable.background_tab_activated)
       binding.tabBtnBeranda.setTextColor(resources.getColor(R.color.primary))

        binding.tabbtnStatistik.setBackgroundResource(R.color.transparansi)
        binding.tabbtnStatistik.setTextColor(resources.getColor(R.color.white))

        binding.tabbtnLapor.setBackgroundResource(R.color.transparansi)
        binding.tabbtnLapor.setTextColor(resources.getColor(R.color.white))

        binding.tabbtnChat.setBackgroundResource(R.color.transparansi)
        binding.tabbtnChat.setTextColor(resources.getColor(R.color.white))
    }
}