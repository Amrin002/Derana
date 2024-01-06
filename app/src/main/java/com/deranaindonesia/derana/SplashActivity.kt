package com.deranaindonesia.derana

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var loadingbar : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

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