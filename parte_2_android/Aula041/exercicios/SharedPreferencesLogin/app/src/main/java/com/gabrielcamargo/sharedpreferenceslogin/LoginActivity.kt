package com.gabrielcamargo.sharedpreferenceslogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.switchmaterial.SwitchMaterial

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnEntrar = findViewById<Button>(R.id.btnEntrar_loginActivity)
        btnEntrar.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        val switch = findViewById<SwitchMaterial>(R.id.switchLembrar_loginActivity)

        val prefs = getSharedPreferences(APP_NAME, MODE_PRIVATE)
        val rememberLoginPrefs = prefs.getBoolean(REMEMBER_LOGIN, false)
        switch.isChecked = rememberLoginPrefs

        switch.setOnCheckedChangeListener { _, isChecked ->
            prefs.edit().putBoolean(REMEMBER_LOGIN, isChecked).apply()
        }
    }

    companion object {
        const val APP_NAME = "Aula41_SharedPreferences"
        const val REMEMBER_LOGIN = "REMEMBER_LOGIN"
    }
}