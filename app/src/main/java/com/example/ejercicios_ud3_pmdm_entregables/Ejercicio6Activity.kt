package com.example.ejercicios_ud3_pmdm_entregables

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio6Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio6)

        // imagen principal del perfil
        val imagenPerfil = findViewById<ImageView>(R.id.imagenPerfil)

        // botones del XML
        val botonPositividad = findViewById<Button>(R.id.botonPositividad)
        val botonAlegria = findViewById<Button>(R.id.botonAlegria)
        val botonCantar = findViewById<Button>(R.id.botonCantar)

        botonPositividad.setOnClickListener {
            imagenPerfil.setImageResource(R.drawable.estrella_positiva)
        }

        botonAlegria.setOnClickListener {
            imagenPerfil.setImageResource(R.drawable.estrella_alegre)
        }

        botonCantar.setOnClickListener {
            imagenPerfil.setImageResource(R.drawable.estrella_cantando)
        }
    }
}
