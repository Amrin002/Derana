package com.deranaindonesia.derana.fragmentlapor

import CameraFragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import com.deranaindonesia.derana.R
import com.deranaindonesia.derana.fragmentberanda.fiturderana.DataBahasaFragment

class KategoriFragment : Fragment(R.layout.fragment_lapor_kategori) {
    private lateinit var kategori1: RelativeLayout
    private lateinit var kategori2: RelativeLayout
    private lateinit var kategori3: RelativeLayout
    private lateinit var kategori4: RelativeLayout
    private lateinit var kategori5: RelativeLayout
    private lateinit var kategori6: RelativeLayout
    private lateinit var kategori7: RelativeLayout
    private lateinit var kategori8: RelativeLayout
    private lateinit var frameLanjut1: FrameLayout
    private lateinit var imgkategoriSet: ImageView
    private lateinit var kategoriSet: TextView
    private lateinit var btnLanjut : Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inisialisasi elemen UI
        kategori1 = view.findViewById(R.id.kategori1)
        kategori2 = view.findViewById(R.id.kategori2)
        kategori3 = view.findViewById(R.id.kategori3)
        kategori4 = view.findViewById(R.id.kategori4)
        kategori5 = view.findViewById(R.id.kategori5)
        kategori6 = view.findViewById(R.id.kategori6)
        kategori7 = view.findViewById(R.id.kategori7)
        kategori8 = view.findViewById(R.id.kategori8)
        frameLanjut1 = view.findViewById(R.id.frameLanjut1)
        btnLanjut = view.findViewById(R.id.btnLanjutLapor1)
        imgkategoriSet = view.findViewById(R.id.imgkategoriSet)
        kategoriSet = view.findViewById(R.id.kategoriSet)

        // Set listener untuk setiap kategori
        kategori1.setOnClickListener {
            onKategoriClicked("Bahasa di ruang publik", R.drawable.kategori1_1) }
        kategori2.setOnClickListener {
            onKategoriClicked("Bahasa daerah", R.drawable.kategori2_2) }
        kategori3.setOnClickListener {
            onKategoriClicked("Kamus Besar Bahasa Indonesia", R.drawable.kategori2_2) }
        kategori4.setOnClickListener {
            onKategoriClicked("Lalu lintas", R.drawable.kategori1_1) }
        kategori5.setOnClickListener {
            onKategoriClicked("Pendidikan", R.drawable.kategori1_1) }
        kategori6.setOnClickListener {
            onKategoriClicked("Sosial", R.drawable.kategori2_2) }
        kategori7.setOnClickListener {
            onKategoriClicked("Kebersihan", R.drawable.kategori1_1) }
        kategori8.setOnClickListener {
            onKategoriClicked("Fasilitas umum", R.drawable.kategori2_2) }
    }

    // Fungsi yang akan dipanggil saat kategori di klik
    private fun onKategoriClicked(kategoriText: String, imageResource: Int) {
        // Ubah visibility FrameLayout menjadi VISIBLE
        frameLanjut1.visibility = View.VISIBLE

        // Set teks dan gambar sesuai dengan kategori yang di klik
        kategoriSet.text = kategoriText
        imgkategoriSet.setImageResource(imageResource)
        btnLanjut.setOnClickListener {
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            val cameraFragment = CameraFragment()
            fragmentTransaction.replace(R.id.fcvLapor, cameraFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        // Tambahkan kode lain yang ingin Anda lakukan ketika kategori di klik di sini
    }
}
