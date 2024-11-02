package com.example.movefit

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class UserListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: UserAdapter
    private var users = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Cargar usuarios desde SharedPreferences
        val sharedPref = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        users = sharedPref.getStringSet("users", setOf())?.toMutableList() ?: mutableListOf()

        adapter = UserAdapter(users) { user ->
            Toast.makeText(this, "Seleccionaste: $user", Toast.LENGTH_SHORT).show()
        }
        recyclerView.adapter = adapter

        // Configura el botón Editar Usuario
        val btnEditUser = findViewById<Button>(R.id.btn_edit_user)
        btnEditUser.setOnClickListener {
            if (users.isNotEmpty()) {
                showEditUserDialog()
            } else {
                Toast.makeText(this, "No hay usuarios para editar", Toast.LENGTH_SHORT).show()
            }
        }

        // Configura el botón Eliminar Usuario
        val btnDeleteUser = findViewById<Button>(R.id.btn_delete_user)
        btnDeleteUser.setOnClickListener {
            if (users.isNotEmpty()) {
                showDeleteUserDialog()
            } else {
                Toast.makeText(this, "No hay usuarios para eliminar", Toast.LENGTH_SHORT).show()
            }
        }

        // Configura el botón Volver
        val btnBack = findViewById<Button>(R.id.btn_back)
        btnBack.setOnClickListener {
            finish() // Vuelve a la pantalla anterior
        }
    }

    // Diálogo para editar el nombre del usuario
    private fun showEditUserDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Editar Usuario")

        val input = EditText(this)
        input.hint = "Nuevo nombre de usuario"
        builder.setView(input)

        builder.setPositiveButton("Guardar") { dialog, _ ->
            val newName = input.text.toString()
            if (newName.isNotEmpty()) {
                // Actualizar el nombre en la lista y SharedPreferences
                val oldName = users[0] // Ejemplo: editamos el primer usuario
                users[0] = newName
                updateUsersInPreferences()
                adapter.notifyDataSetChanged()
                Toast.makeText(this, "Usuario actualizado", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "El nombre no puede estar vacío", Toast.LENGTH_SHORT).show()
            }
            dialog.dismiss()
        }

        builder.setNegativeButton("Cancelar") { dialog, _ -> dialog.cancel() }
        builder.show()
    }

    // Diálogo para confirmar la eliminación del usuario
    private fun showDeleteUserDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Eliminar Usuario")
        builder.setMessage("¿Estás seguro de que quieres eliminar este usuario?")

        builder.setPositiveButton("Eliminar") { dialog, _ ->
            users.removeAt(0) // Ejemplo: eliminamos el primer usuario
            updateUsersInPreferences()
            adapter.notifyDataSetChanged()
            Toast.makeText(this, "Usuario eliminado", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        builder.setNegativeButton("Cancelar") { dialog, _ -> dialog.cancel() }
        builder.show()
    }

    // Función para actualizar los usuarios en SharedPreferences
    private fun updateUsersInPreferences() {
        val sharedPref = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putStringSet("users", users.toSet())
        editor.apply()
    }
}
