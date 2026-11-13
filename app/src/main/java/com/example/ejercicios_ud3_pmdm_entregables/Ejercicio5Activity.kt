package com.example.ejercicios_ud3_pmdm_entregables

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio5Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio5)

        val resultado = findViewById<TextView>(R.id.textResultado)

        // variables para guardar los datos de la operación
        var numero1 = 0.0
        var operacion = ""
        var nuevoNumero = true

        // mostrar los números pulsados
        fun escribirNumero(numero: String) {
            if (nuevoNumero || resultado.text.toString() == "0") {
                resultado.text = numero
                nuevoNumero = false
            } else {
                resultado.text = resultado.text.toString() + numero
            }
        }

        // buscamos todos los botones numéricos
        val botones = listOf(
            R.id.boton0, R.id.boton_1, R.id.boton_2,
            R.id.boton_3, R.id.boton4, R.id.boton5,
            R.id.boton6, R.id.boton7, R.id.boton8,
            R.id.boton9
        )

        // recorremos los botones y detectamos sus pulsaciones
        for (id in botones) {
            val boton = findViewById<Button>(id)

            boton.setOnClickListener {
                escribirNumero(boton.text.toString())
            }
        }

        // botón para introducir decimales
        findViewById<Button>(R.id.botonDecimal).setOnClickListener {

            if (nuevoNumero) {
                resultado.text = "0."
                nuevoNumero = false
            } else if (!resultado.text.toString().contains(".")) {
                resultado.text = resultado.text.toString() + "."
            }
        }

        // guardamos el primer número y la operación
        fun seleccionarOperacion(simbolo: String) {
            numero1 = resultado.text.toString().toDoubleOrNull() ?: 0.0
            operacion = simbolo
            nuevoNumero = true
        }

        // botones de las operaciones
        findViewById<Button>(R.id.botonSuma).setOnClickListener {
            seleccionarOperacion("+")
        }

        findViewById<Button>(R.id.boton_Resta).setOnClickListener {
            seleccionarOperacion("-")
        }

        findViewById<Button>(R.id.botonMultiplicar).setOnClickListener {
            seleccionarOperacion("*")
        }

        findViewById<Button>(R.id.botonDividir).setOnClickListener {
            seleccionarOperacion("/")
        }

        // =: realiza la operación
        findViewById<Button>(R.id.botonIgual).setOnClickListener {

            if (operacion.isNotEmpty()) {

                val numero2 = resultado.text.toString().toDoubleOrNull() ?: 0.0

                if (operacion == "/" && numero2 == 0.0) {

                    Toast.makeText(
                        this,
                        "No se puede dividir entre cero",
                        Toast.LENGTH_SHORT
                    ).show()

                } else {

                    val calculo = when (operacion) {
                        "+" -> numero1 + numero2
                        "-" -> numero1 - numero2
                        "*" -> numero1 * numero2
                        "/" -> numero1 / numero2
                        else -> 0.0
                    }

                    // Evitamos mostrar .0 en resultados enteros
                    if (calculo.isFinite()) {
                        resultado.text = if (calculo % 1.0 == 0.0) {
                            calculo.toLong().toString()
                        } else {
                            calculo.toString()
                        }
                    } else {
                        Toast.makeText(
                            this,
                            "Resultado no válido",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    operacion = ""
                    nuevoNumero = true
                }
            }
        }

        // C: restablece toda la calculadora
        findViewById<Button>(R.id.botonC).setOnClickListener {
            numero1 = 0.0
            operacion = ""
            nuevoNumero = true
            resultado.text = "0"
        }
    }
}
