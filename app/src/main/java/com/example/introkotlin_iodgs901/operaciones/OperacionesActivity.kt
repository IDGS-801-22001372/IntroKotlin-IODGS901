package com.example.introkotlin_iodgs901.operaciones

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.introkotlin_iodgs901.R

class OperacionesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operaciones)

        val etNumero1 = findViewById<EditText>(R.id.etNumero1)
        val etNumero2 = findViewById<EditText>(R.id.etNumero2)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        val btnSumar = findViewById<Button>(R.id.btnSumar)
        val btnRestar = findViewById<Button>(R.id.btnRestar)
        val btnMultiplicar = findViewById<Button>(R.id.btnMultiplicar)
        val btnDividir = findViewById<Button>(R.id.btnDividir)

        fun obtenerNumeros(): Pair<Double, Double>? {
            val num1 = etNumero1.text.toString()
            val num2 = etNumero2.text.toString()
            if (num1.isBlank() || num2.isBlank()) {
                Toast.makeText(this, "Ingresa ambos números", Toast.LENGTH_SHORT).show()
                return null
            }
            return Pair(num1.toDouble(), num2.toDouble())
        }

        btnSumar.setOnClickListener {
            obtenerNumeros()?.let { (a, b) ->
                tvResultado.text = "Resultado: ${a + b}"
            }
        }

        btnRestar.setOnClickListener {
            obtenerNumeros()?.let { (a, b) ->
                tvResultado.text = "Resultado: ${a - b}"
            }
        }

        btnMultiplicar.setOnClickListener {
            obtenerNumeros()?.let { (a, b) ->
                tvResultado.text = "Resultado: ${a * b}"
            }
        }

        btnDividir.setOnClickListener {
            obtenerNumeros()?.let { (a, b) ->
                if (b == 0.0) {
                    Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_SHORT).show()
                } else {
                    tvResultado.text = "Resultado: ${a / b}"
                }
            }
        }
    }
}
