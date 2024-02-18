package com.deranaindonesia.derana

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import androidx.core.content.ContextCompat

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var loadingbar : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val biruColor = ContextCompat.getColor(this, R.color.primary)
        progressBar.indeterminateTintList = ColorStateList.valueOf(biruColor)


        loadingbar = findViewById(R.id.progressBar)
        val thread= Thread{
            try{
                Thread.sleep(1000)
            } catch(e: InterruptedException){
                e.printStackTrace()
            }finally {
                startActivity(Intent(this, OnBoardingActivity::class.java))
                finish()
            }
        }
        thread.start()
    }
}