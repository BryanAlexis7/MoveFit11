package com.example.movefit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        // Configura el botón "Continuar" para redirigir a LoginActivity
        val continueButton = findViewById<Button>(R.id.btn_continue)
        continueButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Cierra WelcomeActivity para evitar regresar a ella
        }
    }
}
