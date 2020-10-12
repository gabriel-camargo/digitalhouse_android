package com.digitalhouse.fakeloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.digitalhouse.fakeloginapp.users.UserService
import kotlinx.android.synthetic.main.activity_create_account.*

class CreateAccount : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        btLogIn.setOnClickListener(this)
        checkAgree.setOnClickListener(this)
        btSignUp.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0) {
            btLogIn -> goToLogin()
            checkAgree -> clickCheckAgree()
            btSignUp -> signUp()
        }
    }

    private fun signUp() {
        val name = etNameSignUp.text.toString()
        val email = etEmailSignUp.text.toString()
        val password = etPasswordSignUp.text.toString()

        if(name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Todos os campos são obrigatórios!", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            UserService.register(name, email, password)
            Toast.makeText(this, "Usuário criado com sucesso!", Toast.LENGTH_SHORT).show()
            finish()
        } catch (e: Exception) {
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun clickCheckAgree() {
        btSignUp.isEnabled = checkAgree.isChecked
    }

    private fun goToLogin() {
        finish()
    }
}