package com.deranaindonesia.derana

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

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
    private val autoSlideInterval =3000L


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
        when (position) {
            0 -> {
                pb1.progress = 100
                pb2.progress = 0
                pb3.progress = 0
                pb4.progress = 0
            }
            1 -> {
                pb1.progress = 100
                pb2.progress = 100
                pb3.progress = 0
                pb4.progress = 0
            }
            2 -> {
                pb1.progress = 100
                pb2.progress = 100
                pb3.progress = 100
                pb4.progress = 0
            }
            3 -> {
                pb1.progress = 100
                pb2.progress = 100
                pb3.progress = 100
                pb4.progress = 100
            }
            // Tambahkan kondisi lain sesuai kebutuhan
        }

    }

    private fun masuk() {
        // Implemantasi button masuk
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }

    private fun daftar() {
        // implementasi Button daftar
        showToast("Daftar")
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
    private fun setBackgroundColor(colorResId: Int) {
        val color = ContextCompat.getColor(this, colorResId)
        viewPager.setBackgroundColor(color)
        window.decorView.setBackgroundColor(color)
    }
    private fun setContrastTextColor(colorResId: Int) {
        val color = ContextCompat.getColor(this, colorResId)
        btnDaftar.setTextColor(getContrastColor(color))
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