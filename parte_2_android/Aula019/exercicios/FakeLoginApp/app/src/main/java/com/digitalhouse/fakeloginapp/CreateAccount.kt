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

        btnLogInSignUp.setOnClickListener(this)
        cbAgreeSignUp.setOnClickListener(this)
        btnSignUp.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0) {
            btnLogInSignUp -> goToLogin()
            cbAgreeSignUp -> clickCheckAgree()
            btnSignUp -> signUp()
        }
    }

    private fun signUp() {
        val name = edtNameSignUp.text.toString()
        val email = edtEmailSignUp.text.toString()
        val password = edtPasswordSignUp.text.toString()

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
        btnSignUp.isEnabled = cbAgreeSignUp.isChecked
    }

    private fun goToLogin() {
        finish()
    }
}