package com.digitalhouse.rickappgrid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val nome = intent.getStringExtra("nome")
        val localizacao = intent.getStringExtra("localizacao")
        val genero = intent.getStringExtra("genero")
        val imagemUrl= intent.getStringExtra("imagemUrl")

        val txtName: TextView = findViewById<TextView>(R.id.txtNameDetails)
        val txtLocalizacao: TextView = findViewById<TextView>(R.id.txtLocationDetails)
        val txtGenero: TextView = findViewById<TextView>(R.id.txtGenderDetails)
        val imgView: ImageView = findViewById<ImageView>(R.id.imagemDetails)

        txtName.text = nome
        txtLocalizacao.text = localizacao
        txtGenero.text = genero
        Picasso.get()
            .load(imagemUrl)
            .into(imgView)
    }

    override fun onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}