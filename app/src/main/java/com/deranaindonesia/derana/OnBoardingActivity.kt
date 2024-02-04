package com.deranaindonesia.derana

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.deranaindonesia.derana.adapter.AdapterViewPager
import com.deranaindonesia.derana.databinding.ActivityOnBoardingBinding

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingBinding
    private lateinit var onBoardingPagerAdapter: AdapterViewPager
    private val handler = Handler()
    private val autoSlideInterval = 3000L
    private var lastProgress1: Int = 0
    private var lastProgress2: Int = 0
    private var lastProgress3: Int = 0
    private var lastProgress4: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onBoardingPagerAdapter = AdapterViewPager(supportFragmentManager, lifecycle)
        binding.viewPager2.adapter = onBoardingPagerAdapter

        binding.viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateProgress(position)
                setProgressBarWithAnimation()
                when (position) {
                    0 -> {
                        setBackgroundColor(R.color.biru)
                        setContrastTextColor(R.color.biru)
                    }
                    1 -> {
                        setBackgroundColor(R.color.merah)
                        setContrastTextColor(R.color.merah)
                    }
                    2 -> {
                        setBackgroundColor(R.color.hijau)
                        setContrastTextColor(R.color.hijau)
                    }
                    3 -> {
                        setBackgroundColor(R.color.ungu)
                        setContrastTextColor(R.color.ungu)
                    }
                }
            }
        })

        handler.postDelayed(object : Runnable {
            override fun run() {
                val nextItem = (binding.viewPager2.currentItem + 1) % onBoardingPagerAdapter.itemCount
                binding.viewPager2.setCurrentItem(nextItem, true)
                handler.postDelayed(this, autoSlideInterval)
            }
        }, autoSlideInterval)

        binding.btnMasuk.setOnClickListener {
            masuk()
        }

        binding.btnReg.setOnClickListener {
            daftar()
        }

        binding.btnKetentuan.setOnClickListener {
            layanan()
        }
        binding.btnPrivasi.setOnClickListener {
            privasi()
        }
    }

    private fun setProgressBarWithAnimation() {
        //nanti dibuat
    }

    private fun updateProgress(position: Int) {
        val duration = autoSlideInterval // Durasi animasi
        when (position) {
            0 -> {
                animateProgressBar(binding.pb1, 100, duration, lastProgress1)
                animateProgressBar(binding.pb2, 0, duration, lastProgress2)
                animateProgressBar(binding.pb3, 0, duration, lastProgress3)
                animateProgressBar(binding.pb4, 0, duration, lastProgress4)
            }
            1 -> {
                animateProgressBar(binding.pb1, 100, duration, lastProgress1)
                animateProgressBar(binding.pb2, 100, duration, lastProgress2)
                animateProgressBar(binding.pb3, 0, duration, lastProgress3)
                animateProgressBar(binding.pb4, 0, duration, lastProgress4)
            }
            2 -> {
                animateProgressBar(binding.pb1, 100, duration, lastProgress1)
                animateProgressBar(binding.pb2, 100, duration, lastProgress2)
                animateProgressBar(binding.pb3, 100, duration, lastProgress3)
                animateProgressBar(binding.pb4, 0, duration, lastProgress4)
            }
            3 -> {
                animateProgressBar(binding.pb1, 100, duration, lastProgress1)
                animateProgressBar(binding.pb2, 100, duration, lastProgress2)
                animateProgressBar(binding.pb3, 100, duration, lastProgress3)
                animateProgressBar(binding.pb4, 100, duration, lastProgress4)
            }
            // Tambahkan kondisi lain sesuai kebutuhan
        }
    }

    private fun animateProgressBar(progressBar: ProgressBar, toProgress: Int, duration: Long, lastProgress: Int) {
        // Animasi dimulai dari nilai terakhir
        val progressBarAnimator = ObjectAnimator.ofInt(progressBar, "progress", lastProgress, toProgress)
        progressBarAnimator.duration = duration
        progressBarAnimator.start()

        // Jika progress sudah penuh, setelah animasi selesai, reset ke 0
        if (toProgress == 100) {
            progressBarAnimator.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                    progressBar.progress = 0
                }
            })
        }

        // Simpan nilai progres terakhir
        when (progressBar) {
            binding.pb1 -> lastProgress1 = toProgress
            binding.pb2 -> lastProgress2 = toProgress
            binding.pb3 -> lastProgress3 = toProgress
            binding.pb4 -> lastProgress4 = toProgress
        }
    }

    private fun masuk() {
        // Implemantasi button masuk
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    private fun daftar() {
        // implementasi Button daftar
        val intent = Intent(this, SignupActivity::class.java)
        startActivity(intent)
    }

    private fun layanan() {
        showToast("Layanan")
        // implementasi Ketentuan layanan ketika diklik
    }

    private fun privasi() {
        showToast("Privasi")
        //implementasi button kebijakan privasi
    }

    private fun showToast(message: String) {
        // Dipakai hanya untuk kepentingan testing
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun setBackgroundColor(colorResId: Int) {
        val color = ContextCompat.getColor(this, colorResId)

        // Setel warna latar belakang untuk ViewPager dan window
        binding.viewPager2.setBackgroundColor(color)
        window.decorView.setBackgroundColor(color)

        // Ubah warna ActionBar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = color
        }

        supportActionBar?.let {
            it.setBackgroundDrawable(ColorDrawable(color))
        }
    }

    private fun setContrastTextColor(colorResId: Int) {
        val color = ContextCompat.getColor(this, colorResId)
        binding.btnReg.setTextColor(getContrastColor(color))
    }

    private fun getContrastColor(color: Int): Int {
        return when (color) {
            ContextCompat.getColor(this, R.color.biru) -> ContextCompat.getColor(this, R.color.biru)
            ContextCompat.getColor(this, R.color.merah) -> ContextCompat.getColor(this, R.color.merah)
            ContextCompat.getColor(this, R.color.hijau) -> ContextCompat.getColor(this, R.color.hijau)
            ContextCompat.getColor(this, R.color.ungu) -> ContextCompat.getColor(this, R.color.ungu)
            else -> Color.BLACK // Default, jika warna tidak sesuai dengan yang diharapkan
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Hentikan handler saat aktivitas dihancurkan
        handler.removeCallbacksAndMessages(null)
    }
}
