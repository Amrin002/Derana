package com.newderanaindonesia.derana

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.newderanaindonesia.derana.databinding.ActivityMainBinding
import com.newderanaindonesia.derana.fragments.ChatFragment
import com.newderanaindonesia.derana.fragments.DiscoverFragment
import com.newderanaindonesia.derana.fragments.HomeFragment
import com.newderanaindonesia.derana.fragments.LearnFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView: BottomNavigationView = binding.bottomNavigation

        bottomNavigationView.setOnItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.navigation_home -> selectedFragment = HomeFragment()
                R.id.navigation_learn -> selectedFragment = LearnFragment()
                R.id.navigation_discover -> selectedFragment = DiscoverFragment()
                R.id.navigation_chat -> selectedFragment = ChatFragment()
            }
            if (selectedFragment != null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit()
            }
            true
        }

        // Set default fragment
        if (savedInstanceState == null) {
            bottomNavigationView.selectedItemId = R.id.navigation_home
        }
    }
}