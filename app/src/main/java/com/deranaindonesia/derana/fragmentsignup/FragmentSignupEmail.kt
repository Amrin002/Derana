package com.deranaindonesia.derana.fragmentsignup

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.View

import android.widget.EditText
import com.deranaindonesia.derana.R
import com.deranaindonesia.derana.datasignup.EmailDataSignup

class FragmentSignupEmail : Fragment(R.layout.fragment_signup_email) {
    private lateinit var etEmail: EditText
    private lateinit var etFullName: EditText
    private lateinit var etPassword: EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inisialisasi EditText di sini
        etEmail = view.findViewById(R.id.etEmailSignup)
        etFullName = view.findViewById(R.id.etNamaSignupEmail)
        etPassword = view.findViewById(R.id.etPassSignupEmail)
    }

    fun getEmailValue(): EmailDataSignup? {
        //persiapan pengirimin nilai ke SignupActivity
        // Pindahkan pengambilan nilai ke sini
        val email = etEmail.text.toString()
        val efullname = etFullName.text.toString()
        val epassword = etPassword.text.toString()

        if (email.isNotEmpty() && efullname.isNotEmpty() && epassword.isNotEmpty()) {
            return EmailDataSignup(email, efullname, epassword)
        } else {
            // Return null jika ada kolom yang belum diisi
            return null
        }
    }
}

