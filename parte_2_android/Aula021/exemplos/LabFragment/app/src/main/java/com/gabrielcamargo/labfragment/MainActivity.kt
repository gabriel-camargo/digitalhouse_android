package com.gabrielcamargo.labfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = supportFragmentManager

        val firstFragment = firstFragment()
        val secondFragment = SecondFragment()

        btnFrg1.setOnClickListener{
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.frmLayout, firstFragment)
            transaction.commit()
        }

        btnFrg2.setOnClickListener{
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.frmLayout, secondFragment)
            transaction.commit()
        }
    }
}