package com.deranaindonesia.derana.adapter


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

import com.deranaindonesia.derana.fragment.Fragment1
import com.deranaindonesia.derana.fragment.Fragment2
import com.deranaindonesia.derana.fragment.Fragment3
import com.deranaindonesia.derana.fragment.Fragment4

class AdapterViewPager(fragment: FragmentManager, lifecycle: Lifecycle):
    FragmentStateAdapter(fragment, lifecycle){
    override fun getItemCount(): Int {
       return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> Fragment1()
            1 -> Fragment2()
            2 -> Fragment3()
            3 -> Fragment4()
            else -> Fragment1()
        }
    }
}