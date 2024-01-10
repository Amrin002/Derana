package com.deranaindonesia.derana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.deranaindonesia.derana.R

class VerificationActivity : AppCompatActivity() {
    private lateinit var textId : TextView
    private lateinit var otp1 : EditText
    private lateinit var otp2 : EditText
    private lateinit var otp3 : EditText
    private lateinit var otp4 : EditText
    private lateinit var otp5 : EditText
    private lateinit var otp6 : EditText

    private lateinit var btnLanjut : Button
    private lateinit var termsSrc : TextView
    private lateinit var  privacyPol : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)

        textId = findViewById(R.id.emailVerification)
        otp1 = findViewById(R.id.etOtp1)
        otp2 = findViewById(R.id.etOtp2)
        otp3 = findViewById(R.id.etOtp3)
        otp4 = findViewById(R.id.etOtp4)
        otp5 = findViewById(R.id.etOtp5)
        otp6 = findViewById(R.id.etOtp6)

        val phoneNumber = intent.getStringExtra("PHONE_NUMBER")

        // Set teks pada TextView
        textId.text = "$phoneNumber"


        // listener untuk memastikan input auto pindah
        otp1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.length == 1) {
                    otp2.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
        otp2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.length == 1) {
                    otp3.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
        otp3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.length == 1) {
                    otp4.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
        otp4.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.length == 1) {
                    otp5.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
        otp5.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.length == 1) {
                    otp6.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        btnLanjut = findViewById(R.id.btnLanjut)
        btnLanjut.setOnClickListener {
            loginverification()
        }

        termsSrc = findViewById(R.id.btnTerms)
        termsSrc.setOnClickListener {
            termsofservide()
        }
        privacyPol = findViewById(R.id.btnPrivaci)
        privacyPol.setOnClickListener {
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
    }
}