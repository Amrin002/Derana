package com.deranaindonesia.derana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.deranaindonesia.derana.R
import com.deranaindonesia.derana.databinding.ActivityVerificationBinding

class VerificationActivity : AppCompatActivity() {
    private lateinit var binding : ActivityVerificationBinding
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val phoneNumber = intent.getStringExtra("PHONE_NUMBER")

        // Set teks pada TextView
        binding.emailVerification.text = "$phoneNumber"


        // listener untuk memastikan input auto pindah
        binding.etOtp1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.length == 1) {
                    binding.etOtp2.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
        binding.etOtp2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.length == 1) {
                    binding.etOtp3.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
        binding.etOtp3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.length == 1) {
                    binding.etOtp4.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
        binding.etOtp4.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.length == 1) {
                    binding.etOtp5.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
        binding.etOtp5.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.length == 1) {
                    binding.etOtp6.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })


        binding.btnLanjut.setOnClickListener {
            loginverification()
        }


        binding.btnTerms.setOnClickListener {
            termsofservide()
        }

        binding.btnPrivaci.setOnClickListener {
            privacypolicy()
        }
    }

    private fun privacypolicy() {
        // text privasi
    }

    private fun termsofservide() {
        // text kebijakan dan privasi
    }

    private fun loginverification() {
        // implementasi verifikasi login
        val intent = Intent(this, BerandaActivity::class.java)
        startActivity(intent)
    }
}