package com.digitalhouse.fakeloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.digitalhouse.fakeloginapp.users.UserModel
import com.digitalhouse.fakeloginapp.users.UserService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCreateAccountMain.setOnClickListener(this)
        btnLogInMain.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0) {
            btnCreateAccountMain -> goToSignUp()
            btnLogInMain -> login()
        }
    }

    private fun login() {
        val email = edtEmailMain.text.toString()
        val password = edtPassWordMain.text.toString()

        val user = UserService.logIn(email, password)

        if(user == null) {
            Toast.makeText(this, "Email ou senha incorretos!", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(this, WelcomeActivity::class.java)
            intent.putExtra("USERNAME", user.name)
            startActivity(intent)
        }
    }

    private fun goToSignUp() {
        val intent = Intent(this,CreateAccount::class.java)
        startActivity(intent)
    }
}