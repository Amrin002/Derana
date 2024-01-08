package com.deranaindonesia.derana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentContainerView
import com.deranaindonesia.derana.fragmentsignup.FragmentSignupEmail
import com.deranaindonesia.derana.fragmentsignup.FragmentSignupTelepon

class SignupActivity : AppCompatActivity() {

    private lateinit var btnBack: ImageButton
    private lateinit var btnSignup: Button
    private lateinit var btnSyarat : TextView
    private lateinit var btnKebijakan : TextView
    private lateinit var btnMasuk : TextView
    private lateinit var btnEmail : Button
    private lateinit var btnPhone : Button
    private lateinit var checkboxKebijakan: CheckBox

    private lateinit var viewRegistrasi : FragmentContainerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        viewRegistrasi = findViewById(R.id.fragmentContainerView)
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, FragmentSignupEmail()).commit()

        checkboxKebijakan = findViewById(R.id.checkboxKebijakan)

        btnBack = findViewById(R.id.backButtonSign)
        btnBack.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnSignup = findViewById(R.id.buttonSignup)
        btnSignup.setOnClickListener{
            signup()
        }
        btnSyarat= findViewById(R.id.Syarat)
        btnSyarat.setOnClickListener{
            syarat()
        }
        btnKebijakan = findViewById(R.id.kebijakan)
        btnKebijakan.setOnClickListener{
            kebijakan()
        }

        btnMasuk = findViewById(R.id.haveAccount)
        btnMasuk.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        btnEmail = findViewById(R.id.emailSignup)
        btnEmail.setOnClickListener {
            emailsignup()
        }

        btnPhone = findViewById(R.id.phoneSignup)
        btnPhone.setOnClickListener {
            phonesignup()
        }


    }

    private fun phonesignup() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, FragmentSignupTelepon())
            .commit()

        // Atur latar belakang tombol yang aktif
        btnEmail.setBackgroundResource(R.color.transparansi)
        btnEmail.setTextColor(resources.getColor(R.color.white))



        btnPhone.setBackgroundResource(R.drawable.backgroundbutton_email_signup)
        btnPhone.setTextColor(resources.getColor(R.color.biru))
        // implementasi
    }

    private fun emailsignup() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, FragmentSignupEmail())
            .commit()

        // Atur latar belakang tombol yang aktif
        btnEmail.setBackgroundResource(R.drawable.backgroundbutton_email_signup)
        btnEmail.setTextColor(resources.getColor(R.color.biru))
        btnPhone.setBackgroundResource(R.color.transparansi)
        btnPhone.setTextColor(resources.getColor(R.color.white))
        // implementasi email signup
    }

    private fun kebijakan() {
        // implemenrasi kebijakan
    }
    private fun syarat() {
        // implementasi syarat

    }

    private fun signup() {
        if (checkboxKebijakan.isChecked) {
            emailSubmit()
            phoneSubmit()
            // Lakukan implementasi signup jika checkbox dicentang
            // ...
        } else {
            // Tampilkan pesan atau ambil tindakan yang sesuai jika checkbox tidak dicentang
            showToast("Anda harus menyetujui kebijakan sebelum mendaftar.")
        }
    }

    private fun phoneSubmit() {
        //implementasi nilai yang diambil dari nomor telepon
        val fragmentSignupPhone = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as? FragmentSignupTelepon
        if (fragmentSignupPhone !=null){
            val phoneData = fragmentSignupPhone.getPhoneValue()
            if (phoneData !=null){
                showToast("Anda Sudah Mengisi semua Kolom Telepon")
            }else{
                showToast("Harap isi semua kolom telepon")
            }
        }
    }

    private fun emailSubmit() {
        // implementasi nilai yang di ambil dari Email
        val fragmentSignupEmail = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as? FragmentSignupEmail

        if (fragmentSignupEmail != null) {
            val emailData = fragmentSignupEmail.getEmailValue()

            if (emailData != null) {
                showToast("Anda sudah menyetujui kebijakan kami")
                // Lakukan implementasi signup jika checkbox dicentang
                // ...
            } else {
                showToast("Harap isi semua kolom input.")
            }
        }
    }


    private fun showToast(message: String) {
        // Dipakai hanya untuk kepentingan testing
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}