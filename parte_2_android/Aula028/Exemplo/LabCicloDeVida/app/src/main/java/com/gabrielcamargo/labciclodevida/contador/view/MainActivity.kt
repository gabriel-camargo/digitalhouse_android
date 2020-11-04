package com.gabrielcamargo.labciclodevida.contador.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.gabrielcamargo.labciclodevida.R
import com.gabrielcamargo.labciclodevida.contador.viewmodel.ContadorViewModel
import com.gabrielcamargo.labciclodevida.contador.viewmodel.ContadorViewModelFactory
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    private lateinit var _viewModel: ContadorViewModel

    private val _txtContador by lazy { findViewById<TextView>(R.id.txtContador_mainActivity)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
        setupUi()
    }

    private fun setupViewModel() {
        _viewModel = ViewModelProvider(
            this,
            ContadorViewModelFactory()
        ).get(ContadorViewModel::class.java)

        _viewModel.contador.observe(this, alterarText)
    }

    private fun setupUi() {
        val button = findViewById<MaterialButton>(R.id.btnClickMe_mainActivity)
        button.setOnClickListener{
            _viewModel.incrementar()
        }
    }

    private val alterarText = Observer<Int> {
        _txtContador.text = it.toString()
    }
}