package com.example.movefit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), CourseAdapter.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Buscar el RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Datos de ejemplo
        val courseList = ArrayList<CourseModel>()
        courseList.add(CourseModel("Curso 1", "Descripción del curso 1", R.drawable.course_image1))
        courseList.add(CourseModel("Curso 2", "Descripción del curso 2", R.drawable.course_image2))
        courseList.add(CourseModel("Curso 3", "Descripción del curso 3", R.drawable.course_image3))

        // Configurar el adaptador con el listener
        val adapter = CourseAdapter(this, courseList, this)
        recyclerView.adapter = adapter

        // Configurar otros botones si los necesitas
        val loginButton = findViewById<Button>(R.id.btn_login)
        loginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    // Implementación del método onItemClick
    override fun onItemClick(course: CourseModel) {
        // Iniciar CourseDetailActivity y pasar los datos del curso
        val intent = Intent(this, CourseDetailActivity::class.java)
        intent.putExtra("COURSE_NAME", course.courseName)
        intent.putExtra("COURSE_DESCRIPTION", course.courseDescription)
        intent.putExtra("COURSE_IMAGE", course.courseImage)
        startActivity(intent)
    }
}
