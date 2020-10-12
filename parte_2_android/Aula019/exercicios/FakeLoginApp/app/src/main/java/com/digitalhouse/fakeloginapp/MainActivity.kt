package com.digitalhouse.fakeloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCreateAccount.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0) {
            btnCreateAccount -> goToSignUp()
        }
    }

    private fun goToSignUp() {
        val intent = Intent(this,CreateAccount::class.java)
        startActivity(intent)
    }
}