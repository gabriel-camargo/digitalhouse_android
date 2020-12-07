package com.gabrielcamargo.labsharedprederences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val switch = findViewById<SwitchMaterial>(R.id.switchNotificacoes_mainActivity)

        val prefs = getSharedPreferences(APP_NAME, MODE_PRIVATE)
        val prefsChecked = prefs.getBoolean(NOTIFICATION_PREFS, false)
        switch.isChecked = prefsChecked

        switch.setOnCheckedChangeListener { _, isChecked ->
            prefs.edit().putBoolean(NOTIFICATION_PREFS, isChecked).apply()
        }
    }

    companion object {
        const val APP_NAME = "Aula41_Prefs"
        const val NOTIFICATION_PREFS = "NOTIFICATION_PREFS"
    }
}