package com.deranaindonesia.derana.fragmentsignup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.deranaindonesia.derana.R
import com.deranaindonesia.derana.databinding.FragmentSignupTeleponBinding
import com.deranaindonesia.derana.datasignup.PhoneDataSignUp


class FragmentSignupTelepon : Fragment(R.layout.fragment_signup_telepon) {


    private var _binding : FragmentSignupTeleponBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSignupTeleponBinding.bind(view)

    }

    fun getPhoneValue(): PhoneDataSignUp? {
        //persiapan pengirimin nilai ke SignupActivity
        val phone = binding.etPhoneSignup.text.toString()
        val pfullname = binding.etNamaSignupPhone.text.toString()
        val ppassword = binding.etPassSignupPhone.text.toString()

        if (phone.isNotBlank() && pfullname.isNotEmpty() && ppassword.isNotEmpty()) {
            return PhoneDataSignUp(phone, pfullname, ppassword)
        }else{
            return null
        }

    }
}