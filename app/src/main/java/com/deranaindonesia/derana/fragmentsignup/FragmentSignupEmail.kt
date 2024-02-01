package com.deranaindonesia.derana.fragmentsignup

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.View

import android.widget.EditText
import com.deranaindonesia.derana.R
import com.deranaindonesia.derana.databinding.FragmentSignupEmailBinding
import com.deranaindonesia.derana.datasignup.EmailDataSignup

class FragmentSignupEmail : Fragment(R.layout.fragment_signup_email) {

    private var _binding : FragmentSignupEmailBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSignupEmailBinding.bind(view)


    }

    fun getEmailValue(): EmailDataSignup? {
        //persiapan pengirimin nilai ke SignupActivity
        // Pindahkan pengambilan nilai ke sini
        val email = binding.etEmailSignup.text.toString()
        val efullname = binding.etNamaSignupEmail.text.toString()
        val epassword = binding.etPassSignupEmail.text.toString()

        if (email.isNotEmpty() && efullname.isNotEmpty() && epassword.isNotEmpty()) {
            return EmailDataSignup(email, efullname, epassword)
        } else {
            // Return null jika ada kolom yang belum diisi
            return null
        }
    }
}

