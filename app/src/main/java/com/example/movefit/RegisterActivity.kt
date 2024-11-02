package com.example.movefit

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Obtén referencias a los campos de entrada
        val etRut = findViewById<EditText>(R.id.et_rut)
        val etNombre = findViewById<EditText>(R.id.et_nombre)
        val etApellidoPaterno = findViewById<EditText>(R.id.et_apellidoPaterno)
        val etApellidoMaterno = findViewById<EditText>(R.id.et_apellidoMaterno)
        val etEdad = findViewById<EditText>(R.id.et_edad)
        val rgGenero = findViewById<RadioGroup>(R.id.rg_genero)
        val etUsername = findViewById<EditText>(R.id.et_username)
        val etCorreo = findViewById<EditText>(R.id.et_correo)
        val etPassword = findViewById<EditText>(R.id.et_password)

        // Botones
        val btnRegistrar = findViewById<Button>(R.id.btn_registrar)
        val btnVolver = findViewById<Button>(R.id.btn_volver)

        // Configura el botón "Registrar"
        btnRegistrar.setOnClickListener {
            val rut = etRut.text.toString()
            val nombre = etNombre.text.toString()
            val apellidoPaterno = etApellidoPaterno.text.toString()
            val apellidoMaterno = etApellidoMaterno.text.toString()
            val edad = etEdad.text.toString()
            val generoId = rgGenero.checkedRadioButtonId
            val username = etUsername.text.toString()
            val correo = etCorreo.text.toString()
            val password = etPassword.text.toString()

            // Obtiene el género seleccionado
            val genero = if (generoId != -1) {
                findViewById<RadioButton>(generoId).text.toString()
            } else {
                ""
            }

            // Verificar que todos los campos requeridos estén llenos
            if (rut.isNotEmpty() && nombre.isNotEmpty() && apellidoPaterno.isNotEmpty() &&
                edad.isNotEmpty() && username.isNotEmpty() && correo.isNotEmpty() && password.isNotEmpty()
            ) {
                // Guardar el usuario en SharedPreferences
                val sharedPref = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
                val editor = sharedPref.edit()

                // Guardar el nombre de usuario en una lista de usuarios
                val users = sharedPref.getStringSet("users", mutableSetOf()) ?: mutableSetOf()
                users.add(username)
                editor.putStringSet("users", users)

                // Guardar los datos específicos del usuario
                editor.putString("rut_$username", rut)
                editor.putString("nombre_$username", nombre)
                editor.putString("apellidoPaterno_$username", apellidoPaterno)
                editor.putString("apellidoMaterno_$username", apellidoMaterno)
                editor.putString("edad_$username", edad)
                editor.putString("genero_$username", genero)
                editor.putString("correo_$username", correo)
                editor.putString("password_$username", password)
                editor.apply()

                // Mostrar un mensaje de éxito
                Toast.makeText(this, "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show()

                // Redirigir a la lista de usuarios después del registro
                val intent = Intent(this, UserListActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        // Configura el botón "Volver"
        btnVolver.setOnClickListener {
            // Finalizar la actividad actual y volver a la pantalla anterior
            finish()
        }
    }
}
