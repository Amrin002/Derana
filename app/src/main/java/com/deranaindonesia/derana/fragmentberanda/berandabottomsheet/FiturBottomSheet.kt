package com.deranaindonesia.derana.fragmentberanda.berandabottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.deranaindonesia.derana.R

import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FiturBottomSheet : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout._ly_beranda_allfitur, container, false)
    }
}