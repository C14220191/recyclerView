package com.example.recyclerview

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.squareup.picasso.Picasso

class detWayang : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_det_wayang)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val _ivFoto = findViewById<ImageView>(R.id.ivFoto)
        val _tvNama = findViewById<TextView>(R.id.tvNama)
        val _tvDetail = findViewById<TextView>(R.id.tvDetail)

        val dataIntent = intent.getParcelableExtra<wayang>("kirimData", wayang::class.java)
        if (dataIntent != null) {
            Log.d("detWayang", dataIntent.nama)
            Picasso.get()
                .load(dataIntent.foto)
                .into(_ivFoto)
            _tvDetail.setText(dataIntent.deskripsi)
            _tvNama.setText(dataIntent.nama)
        }


    }
}