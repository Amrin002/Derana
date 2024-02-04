package com.deranaindonesia.derana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast
import androidx.fragment.app.FragmentContainerView
import com.deranaindonesia.derana.databinding.ActivitySignupBinding
import com.deranaindonesia.derana.fragmentsignup.FragmentSignupEmail
import com.deranaindonesia.derana.fragmentsignup.FragmentSignupTelepon

class SignupActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySignupBinding
    private lateinit var checkboxKebijakan: CheckBox

    private lateinit var viewRegistrasi : FragmentContainerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewRegistrasi = findViewById(R.id.fragmentContainerView)
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, FragmentSignupEmail()).commit()

        checkboxKebijakan = findViewById(R.id.checkboxKebijakan)

        binding.backButtonSign.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


        binding.buttonSignup.setOnClickListener{
            signup()
        }

        binding.Syarat.setOnClickListener{
            syarat()
        }

        binding.kebijakan.setOnClickListener{
            kebijakan()
        }


        binding.haveAccount.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.emailSignup.setOnClickListener {
            emailsignup()
        }


        binding.phoneSignup.setOnClickListener {
            phonesignup()
        }


    }

    private fun phonesignup() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, FragmentSignupTelepon())
            .commit()

        // Atur latar belakang tombol yang aktif
        binding.emailSignup.setBackgroundResource(R.color.transparansi)
        binding.emailSignup.setTextColor(resources.getColor(R.color.white))



        binding.phoneSignup.setBackgroundResource(R.drawable.backgroundbutton_email_signup)
        binding.phoneSignup.setTextColor(resources.getColor(R.color.biru))
        // implementasi
    }

    private fun emailsignup() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, FragmentSignupEmail())
            .commit()

        // Atur latar belakang tombol yang aktif
        binding.emailSignup.setBackgroundResource(R.drawable.backgroundbutton_email_signup)
        binding.emailSignup.setTextColor(resources.getColor(R.color.biru))
        binding.phoneSignup.setBackgroundResource(R.color.transparansi)
        binding.phoneSignup.setTextColor(resources.getColor(R.color.white))
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