package com.deranaindonesia.derana


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //inisialisai variabel
    private lateinit var etPhone : EditText
    private lateinit var btnMasuk : Button
    private lateinit var btnDaftar : Button
    private lateinit var btnAltFb : Button
    private lateinit var btnAltGoogle : Button
    private lateinit var btnKetentuan : TextView
    private lateinit var btnPrivasi : TextView
    private lateinit var btnKendala : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masuk)

        //identifikasi Variable
        btnMasuk = findViewById(R.id.btnMasuk)
        btnDaftar = findViewById(R.id.btnReg)
        btnAltFb = findViewById(R.id.altFacebook)
        btnAltGoogle = findViewById(R.id.altGoogle)
        btnKetentuan = findViewById(R.id.btnKetentuan)
        btnPrivasi = findViewById(R.id.btnPrivasi)
        etPhone = findViewById(R.id.etPhoneNumber)
        btnKendala = findViewById(R.id.txKendala)

        btnMasuk.setOnClickListener{
            masuk()
        }

        btnDaftar.setOnClickListener{
            daftar()
        }

        btnKendala.setOnClickListener{
            kendala()
        }
        btnAltFb.setOnClickListener{
            altFb()
        }
        btnAltGoogle.setOnClickListener{
            altGoogle()
        }

        btnKetentuan.setOnClickListener{
            layanan()
        }
        btnPrivasi.setOnClickListener{
            privasi()
        }

    }

    private fun masuk() {
        val phone = etPhone.text.toString().trim()

        Log.d("Masuk", "Nomor telepon: $phone")

        if (phone.length <= 10) {
            showToast("Nomor telepon harus berisi 10 angka")
            return
        }
        // Implemantasi button masuk
        verfication()
    }

    private fun verfication() {
        val phone = etPhone.text.toString().trim()
        val intent = Intent(this, VerificationActivity::class.java)
        intent.putExtra("PHONE_NUMBER", phone)
        startActivity(intent)
    }

    private fun daftar() {
        // implementasi Button daftar
        val intent = Intent(this, SignupActivity::class.java)
        startActivity(intent)
    }
    private fun kendala() {
        showToast("Kendala")
        // implementasi button kendala masuk
    }
    private fun altFb() {
        showToast("Alt Fb")
        // implementasi Button Alternatif login Facebook
    }

    private fun altGoogle() {
        showToast("Alt Google")
        // implenemtasi button alternative login google

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


}