package com.deranaindonesia.derana

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat


import androidx.viewpager2.widget.ViewPager2
import com.deranaindonesia.derana.adapter.AdapterViewPager

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var btnMasuk : Button
    private lateinit var btnDaftar : Button
    private lateinit var btnKetentuan : TextView
    private lateinit var btnPrivasi : TextView

    private lateinit var viewPager : ViewPager2
    private lateinit var pb1 : ProgressBar
    private lateinit var pb2 : ProgressBar
    private lateinit var pb3 : ProgressBar
    private lateinit var pb4 : ProgressBar
    private lateinit var onBoardingPagerAdapter: AdapterViewPager
    private val handler = Handler()
    private val autoSlideInterval = 3000L


    private var lastProgress1: Int = 0
    private var lastProgress2: Int = 0
    private var lastProgress3: Int = 0
    private var lastProgress4: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        //identifikasi Variable
        btnMasuk = findViewById(R.id.btnMasuk)

        btnDaftar = findViewById(R.id.btnReg)



        btnKetentuan = findViewById(R.id.btnKetentuan)
        btnPrivasi = findViewById(R.id.btnPrivasi)

        viewPager = findViewById(R.id.viewPager2)
        pb1 = findViewById(R.id.pb1)
        pb2 = findViewById(R.id.pb2)
        pb3 = findViewById(R.id.pb3)
        pb4 = findViewById(R.id.pb4)

        onBoardingPagerAdapter = AdapterViewPager(supportFragmentManager, lifecycle)
        viewPager.adapter = onBoardingPagerAdapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
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

        handler.postDelayed(object :Runnable {
            override fun run() {
                val nextItem = (viewPager.currentItem + 1) % onBoardingPagerAdapter.itemCount
                viewPager.setCurrentItem(nextItem, true)
                handler.postDelayed(this, autoSlideInterval)
            }
        }, autoSlideInterval)



        btnMasuk.setOnClickListener{
            masuk()
        }

        btnDaftar.setOnClickListener{
            daftar()
        }

        btnKetentuan.setOnClickListener{
            layanan()
        }
        btnPrivasi.setOnClickListener{
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
                animateProgressBar(pb1, 100, duration, lastProgress1)
                animateProgressBar(pb2, 0, duration, lastProgress2)
                animateProgressBar(pb3, 0, duration, lastProgress3)
                animateProgressBar(pb4, 0, duration, lastProgress4)
            }
            1 -> {
                animateProgressBar(pb1, 100, duration, lastProgress1)
                animateProgressBar(pb2, 100, duration, lastProgress2)
                animateProgressBar(pb3, 0, duration, lastProgress3)
                animateProgressBar(pb4, 0, duration, lastProgress4)
            }
            2 -> {
                animateProgressBar(pb1, 100, duration, lastProgress1)
                animateProgressBar(pb2, 100, duration, lastProgress2)
                animateProgressBar(pb3, 100, duration, lastProgress3)
                animateProgressBar(pb4, 0, duration, lastProgress4)
            }
            3 -> {
                animateProgressBar(pb1, 100, duration, lastProgress1)
                animateProgressBar(pb2, 100, duration, lastProgress2)
                animateProgressBar(pb3, 100, duration, lastProgress3)
                animateProgressBar(pb4, 100, duration, lastProgress4)
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
            pb1 -> lastProgress1 = toProgress
            pb2 -> lastProgress2 = toProgress
            pb3 -> lastProgress3 = toProgress
            pb4 -> lastProgress4 = toProgress
        }
    }
//private fun updateProgress(position: Int) {
//    val duration = autoSlideInterval // Durasi animasi
//    val progressBarList = listOf(pb1, pb2, pb3, pb4)
//
//    for (i in progressBarList.indices) {
//        val toProgress = if (i == position) 100 else 0
//        animateProgressBar(progressBarList[i], toProgress, duration, getLastProgress(i))
//    }
//}
//
//    private fun getLastProgress(index: Int): Int {
//        return when (index) {
//            0 -> lastProgress1
//            1 -> lastProgress2
//            2 -> lastProgress3
//            3 -> lastProgress4
//            else -> 0
//        }
//    }
//
//    private fun animateProgressBar(progressBar: ProgressBar, toProgress: Int, duration: Long, lastProgress: Int) {
//        // Animasi dimulai dari nilai terakhir
//        val progressBarAnimator = ObjectAnimator.ofInt(progressBar, "progress", lastProgress, toProgress)
//        progressBarAnimator.duration = duration
//        progressBarAnimator.start()
//
//        // Jika progress sudah penuh, setelah animasi selesai, reset ke 0
//        if (toProgress == 100) {
//            progressBarAnimator.addListener(object : AnimatorListenerAdapter() {
//                override fun onAnimationEnd(animation: Animator) {
//                    super.onAnimationEnd(animation)
//                    progressBar.progress = 0
//                }
//            })
//        }
//
//        // Simpan nilai progres terakhir
//        updateLastProgress(progressBar, toProgress)
//    }
//
//    private fun updateLastProgress(progressBar: ProgressBar, toProgress: Int) {
//        when (progressBar) {
//            pb1 -> lastProgress1 = toProgress
//            pb2 -> lastProgress2 = toProgress
//            pb3 -> lastProgress3 = toProgress
//            pb4 -> lastProgress4 = toProgress
//        }
//    }




    private fun masuk() {
        // Implemantasi button masuk
        val intent = Intent(this, MainActivity::class.java)
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
    override fun onDestroy() {
        super.onDestroy()
        // Hentikan handler saat aktivitas dihancurkan
        handler.removeCallbacksAndMessages(null)
    }
//    private fun setBackgroundColor(colorResId: Int) {
//        val color = ContextCompat.getColor(this, colorResId)
//        viewPager.setBackgroundColor(color)
//        window.decorView.setBackgroundColor(color)
//    }
//    private fun setContrastTextColor(colorResId: Int) {
//        val color = ContextCompat.getColor(this, colorResId)
//        btnDaftar.setTextColor(getContrastColor(color))
//    }
    private fun setBackgroundColor(colorResId: Int) {
        val color = ContextCompat.getColor(this, colorResId)

        // Setel warna latar belakang untuk ViewPager dan window
        viewPager.setBackgroundColor(color)
        window.decorView.setBackgroundColor(color)

        // Ubah warna ActionBar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = color
        }

        supportActionBar?.let {
            it.setBackgroundDrawable(ColorDrawable(color))
//            it.setHomeAsUpIndicator(R.drawable.ic_back) // Sesuaikan indikator tombol kembali jika diperlukan
        }

        // Ubah warna elemen ActionBar lainnya jika diperlukan
        // Contoh: it.title = "Judul ActionBar Anda"
    }

    private fun setContrastTextColor(colorResId: Int) {
        val color = ContextCompat.getColor(this, colorResId)

        // Setel warna teks untuk elemen UI yang relevan
        btnDaftar.setTextColor(getContrastColor(color))

        // Ubah warna teks ActionBar
        supportActionBar?.let {
        }
    }

    // Fungsi untuk mendapatkan warna kontras
    private fun getContrastColor(color: Int): Int {
        return when (color) {
            ContextCompat.getColor(this, R.color.biru) -> ContextCompat.getColor(this, R.color.biru)
            ContextCompat.getColor(this, R.color.merah) -> ContextCompat.getColor(this, R.color.merah)
            ContextCompat.getColor(this, R.color.hijau) -> ContextCompat.getColor(this, R.color.hijau)
            ContextCompat.getColor(this, R.color.ungu) -> ContextCompat.getColor(this, R.color.ungu)
            else -> Color.BLACK // Default, jika warna tidak sesuai dengan yang diharapkan
        }
    }


}