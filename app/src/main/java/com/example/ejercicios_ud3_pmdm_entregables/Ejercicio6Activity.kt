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
        enableEdgeToEdge()

        // Cargamos la pantalla del ejercicio 6
        setContentView(R.layout.activity_ejercicio6)

        // Adaptamos la pantalla a las barras del móvil
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            val margen = (20 * resources.displayMetrics.density).toInt()

            v.setPadding(
                systemBars.left + margen,
                systemBars.top + margen,
                systemBars.right + margen,
                systemBars.bottom + margen
            )
            insets
        }

        // Recuperamos la imagen del perfil
        val imagenPerfil = findViewById<ImageView>(R.id.imagenPerfil)

        // Recuperamos los tres botones del XML
        val botonPositividad = findViewById<Button>(R.id.botonPositividad)
        val botonAlegria = findViewById<Button>(R.id.botonAlegria)
        val botonCantar = findViewById<Button>(R.id.botonCantar)

        // Al pulsar Positiva mostramos la imagen positiva
        botonPositividad.setOnClickListener {
            imagenPerfil.setImageResource(R.drawable.estrella_positiva)
        }

        // Al pulsar Alegre mostramos la imagen alegre
        botonAlegria.setOnClickListener {
            imagenPerfil.setImageResource(R.drawable.estrella_alegre)
        }

        // Al pulsar Cantando mostramos la imagen cantando
        botonCantar.setOnClickListener {
            imagenPerfil.setImageResource(R.drawable.estrella_cantando)
        }
    }
}
