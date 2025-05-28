package com.example.introkotlin_iodgs901.diccionario

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin_iodgs901.R
import java.io.BufferedReader
import java.io.InputStreamReader

class BuscarActivity : AppCompatActivity() {

    private val fileName = "datos.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_buscar)

        val rbEspanol = findViewById<RadioButton>(R.id.rbEspanol)
        val rbIngles = findViewById<RadioButton>(R.id.rbIngles)
        val editBuscar = findViewById<EditText>(R.id.editBuscarPalabra)
        val btnBuscar = findViewById<Button>(R.id.btnBuscar)
        val tvAlerta = findViewById<TextView>(R.id.tvAlerta)
        val tvTraduccion = findViewById<TextView>(R.id.tvTraduccion)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar)

        btnBuscar.setOnClickListener {
            val palabra = editBuscar.text.toString().trim()
            if (palabra.isEmpty()) {
                tvAlerta.text = "Por favor ingresa una palabra"
                tvAlerta.setTextColor(resources.getColor(android.R.color.holo_red_dark))
                tvAlerta.visibility = TextView.VISIBLE
                tvTraduccion.text = ""
                return@setOnClickListener
            }

            val resultado = buscarPalabra(palabra, rbEspanol.isChecked)

            if (resultado != null) {
                tvAlerta.text = "Palabra encontrada"
                tvAlerta.setTextColor(resources.getColor(android.R.color.holo_green_dark))
                tvAlerta.visibility = TextView.VISIBLE
                tvTraduccion.text = resultado
            } else {
                tvAlerta.text = "Palabra no encontrada"
                tvAlerta.setTextColor(resources.getColor(android.R.color.holo_red_dark))
                tvAlerta.visibility = TextView.VISIBLE
                tvTraduccion.text = ""
            }
        }

        btnRegresar.setOnClickListener {
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun buscarPalabra(palabra: String, busquedaPorEspanol: Boolean): String? {
        try {
            openFileInput(fileName).use { fis ->
                BufferedReader(InputStreamReader(fis)).useLines { lines ->
                    for (line in lines) {
                        val partes = line.split(":")  // Cambio aquí de "," a ":"
                        if (partes.size == 2) {
                            val espanol = partes[0].trim()
                            val ingles = partes[1].trim()
                            if (busquedaPorEspanol) {
                                // Si se busca por Español, se ingresa palabra en inglés y devuelve español
                                if (ingles.equals(palabra, ignoreCase = true)) {
                                    return espanol
                                }
                            } else {
                                // Si se busca por Inglés, se ingresa palabra en español y devuelve inglés
                                if (espanol.equals(palabra, ignoreCase = true)) {
                                    return ingles
                                }
                            }
                        }
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}
