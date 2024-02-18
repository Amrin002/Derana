package com.deranaindonesia.derana


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.deranaindonesia.derana.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //identifikasi Variable


        binding.btnMasuk.setOnClickListener{
            masuk()
        }

        binding.btnReg.setOnClickListener{
            daftar()
        }

        binding.txKendala.setOnClickListener{
            kendala()
        }
        binding.altFacebook.setOnClickListener{
            altFb()
        }
        binding.altGoogle.setOnClickListener{
            altGoogle()
        }

        binding.btnKetentuan.setOnClickListener{
            layanan()
        }
        binding.btnPrivasi.setOnClickListener{
            privasi()
        }

    }

    private fun masuk() {
        val phone = binding.etPhoneNumber.text.toString().trim()

        Log.d("Masuk", "Nomor telepon: $phone")

        if (phone.length <= 10) {
            showToast("Nomor telepon harus berisi 10 angka")
            return
        }
        // Implemantasi button masuk
        verfication()
    }

    private fun verfication() {
        val phone = binding.etPhoneNumber.text.toString().trim()
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