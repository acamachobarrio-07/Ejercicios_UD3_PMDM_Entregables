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

        // Recogemos los elementos del XML
        val editUrl = findViewById<EditText>(R.id.editUrl)
        val botonAbrir = findViewById<Button>(R.id.botonAbrir)

        // Detectamos cuando se pulsa el botón
        botonAbrir.setOnClickListener {

            // Obtenemos la dirección escrita
            val url = editUrl.text.toString().trim()

            // Comprobamos si la URL es válida
            if (url.isEmpty() ||
                !Patterns.WEB_URL.matcher(url).matches() ||
                !(url.startsWith("https://") || url.startsWith("http://"))) {

                // Mostramos un mensaje de error
                Toast.makeText(
                    this,
                    "Introduce una URL válida",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                // Abrimos la URL
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)

            }
        }
    }
}
