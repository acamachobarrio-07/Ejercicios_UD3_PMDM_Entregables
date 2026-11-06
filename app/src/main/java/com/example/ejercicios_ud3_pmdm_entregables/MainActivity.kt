package com.example.ejercicios_ud3_pmdm_entregables

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val botonEjercicio1 = findViewById<Button>(R.id.botonEjercicio1)

        botonEjercicio1.setOnClickListener {
            val intent = Intent(this, Ejercicio1Activity::class.java)
            startActivity(intent)
        }

        val botonEjercicio2 = findViewById<Button>(R.id.botonEjercicio2)

        botonEjercicio2.setOnClickListener {
            // Handler permite ejecutar una acción después de un tiempo
            // Looper.getMainLooper() utiliza el hilo principal de la aplicación
            Handler(Looper.getMainLooper()).postDelayed({

                val intent = Intent(this, Ejercicio2Activity::class.java)
                startActivity(intent)

            }, 10000) //10000 milisegundos equivalen a 10 segundos

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}