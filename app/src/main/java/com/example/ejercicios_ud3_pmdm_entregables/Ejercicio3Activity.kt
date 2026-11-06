package com.example.ejercicios_ud3_pmdm_entregables

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio3)
        val botonPantalla1 = findViewById<Button>(R.id.botonPantalla1)

        botonPantalla1.setOnClickListener {
            val intent = Intent(this, Pantalla1Activity::class.java)
            startActivity(intent)
        }

        val botonPantalla2 = findViewById<Button>(R.id.botonPantalla2)

        botonPantalla2.setOnClickListener {
            val intent = Intent(this, Pantalla2Activity::class.java)
            startActivity(intent)
        }

        val botonPantalla3 = findViewById<Button>(R.id.botonPantalla3)

        botonPantalla3.setOnClickListener {
            val intent = Intent(this, Pantalla3Activity::class.java)
            startActivity(intent)
        }
    }
}