package com.example.ejercicios_ud3_pmdm_entregables

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Ejercicio1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio1)

        val editUrl = findViewById<EditText>(R.id.editUrl)
        val botonAbrir = findViewById<Button>(R.id.botonAbrir)

        // detecta cuando se pulsa el boton
        botonAbrir.setOnClickListener {

            // Obtenemos el texto y eliminamos todos los espacios de los extremos
            val url = editUrl.text.toString().trim()

            // comprobación de si la URL es válida
            if (url.isEmpty() ||
                !Patterns.WEB_URL.matcher(url).matches() ||
                !(url.startsWith("https://") || url.startsWith("http://")))  {

                // mensaje de error sino es valida
                Toast.makeText(
                    this,
                    "Introduce una URL válida",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                // usamos el intent para abrir la web
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                //ejecutamos el intent
                startActivity(intent)

            }
        }
    }
}
