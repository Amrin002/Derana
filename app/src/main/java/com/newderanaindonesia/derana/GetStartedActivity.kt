package com.newderanaindonesia.derana

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.newderanaindonesia.derana.databinding.ActivityGetStartedBinding

class GetStartedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGetStartedBinding
    private lateinit var viewPager : ViewPager2
    private val handler = Handler(Looper.getMainLooper())
    private val autoScrollRunnable = object : Runnable {
        override fun run() {
            val itemCount = viewPager.adapter?.itemCount ?: 0
            val nextItem = (viewPager.currentItem + 1) % itemCount
            viewPager.setCurrentItem(nextItem, true)
            handler.postDelayed(this, 3000) // Auto scroll every 3 seconds
        }
    }
//    private lateinit var tabLayout : TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetStartedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = getColor(R.color.primaryColor)
        }
        enableEdgeToEdge()
//        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        viewPager = binding.vpGetStarted
//        tabLayout = binding.tbGetstarted

        val layouts = listOf(
            R.layout.get_started_1,
            R.layout.get_started_2,
            R.layout.get_started_3,
        )
        val adapter = SliderPagerAdapter(layouts)
        viewPager.adapter = adapter

        // Start auto-scrolling
        handler.postDelayed(autoScrollRunnable, 10000)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateIndicator(position)
            }
        })
        updateIndicator(0)
        binding.loginFacebook.setOnClickListener {
            val intent = Intent(this@GetStartedActivity,MainActivity::class.java)
            startActivity(intent)
        }


//        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
//            tab.text = "Tab ${position + 1}"
//        }.attach()
    }
    private fun updateIndicator(position: Int) {
        val indicators = listOf(binding.vp1, binding.vp2, binding.vp3)
        indicators.forEachIndexed { index, imageView ->
            if (index == position) {
                imageView.setColorFilter(resources.getColor(R.color.primaryColor, null))
            } else {
                imageView.setColorFilter(resources.getColor(R.color.gray, null))
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(autoScrollRunnable)
    }
}








// Class Adapter
class SliderPagerAdapter(private val layouts: List<Int>) : RecyclerView.Adapter<SliderPagerAdapter.SliderViewHolder>(){
    class SliderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return SliderViewHolder(view)
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
//        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = layouts.size

    override fun getItemViewType(position: Int): Int = layouts[position]


}