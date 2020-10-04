package com.gabrielcamargo.conversordetemperatura

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnConverter.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v) {
            btnConverter -> calcularTemperatura()
        }
    }

    private fun calcularTemperatura() {
        val tempC = edtTemperatura.text!!.toString().toFloat()
        val tempF: Float = ( (tempC*9) / 5) + 32

        txtF.text = "%.2f".format(tempF)
    }
}