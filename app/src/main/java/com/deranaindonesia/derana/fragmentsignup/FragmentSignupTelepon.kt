package com.deranaindonesia.derana.fragmentsignup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.deranaindonesia.derana.R
import com.deranaindonesia.derana.datasignup.PhoneDataSignUp


class FragmentSignupTelepon : Fragment(R.layout.fragment_signup_telepon) {
    private lateinit var etPhone: EditText
    private lateinit var etFullNamePhone: EditText
    private lateinit var etPasswordPhone: EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        etPhone = requireView().findViewById(R.id.etPhoneSignup)
        etFullNamePhone = requireView().findViewById(R.id.etNamaSignupPhone)
        etPasswordPhone = requireView().findViewById(R.id.etPassSignupPhone)
    }

    fun getPhoneValue(): PhoneDataSignUp? {
        //persiapan pengirimin nilai ke SignupActivity
        val phone = etPhone.text.toString()
        val pfullname = etFullNamePhone.text.toString()
        val ppassword = etPasswordPhone.text.toString()

        if (phone.isNotBlank() && pfullname.isNotEmpty() && ppassword.isNotEmpty()) {
            return PhoneDataSignUp(phone, pfullname, ppassword)
        }else{
            return null
        }

    }
}