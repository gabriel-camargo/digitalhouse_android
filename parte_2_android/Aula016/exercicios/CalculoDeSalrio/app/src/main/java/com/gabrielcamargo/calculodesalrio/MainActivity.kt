package com.gabrielcamargo.calculodesalrio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v) {
            btnCalcular -> calcularSalario()
        }
    }

    private fun calcularSalario() {
        var qtdHoras: Double = 0.0
        var valorHora:Double = 0.0
        var salario:Double = 0.0

        try {
            qtdHoras = edtHoras.text.toString()!!.toDouble()
            valorHora = edtValor.text.toString()!!.toDouble()
            salario = (qtdHoras * valorHora)
        } catch (ex: NumberFormatException) {
            salario.text = "0,00"
        }

        salario.text = "%.2f".format((qtdHoras * valorHora))
    }
}