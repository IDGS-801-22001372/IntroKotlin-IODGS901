package com.example.introkotlin_iodgs901.diccionario

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin_iodgs901.R
import java.io.IOException

class CapturaActivity : AppCompatActivity() {

    private val fileName = "datos.txt"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_captura)

        val etEspanol = findViewById<EditText>(R.id.editEspanol)
        val etIngles = findViewById<EditText>(R.id.editIngles)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val tvMensaje = findViewById<TextView>(R.id.tvMensaje)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar)

        btnGuardar.setOnClickListener {
            val palabraEspanol = etEspanol.text.toString().trim()
            val palabraIngles = etIngles.text.toString().trim()

            if (palabraEspanol.isEmpty() || palabraIngles.isEmpty()) {
                tvMensaje.setTextColor(resources.getColor(android.R.color.holo_red_dark))
                tvMensaje.text = "Por favor, ingresa ambas palabras"
                tvMensaje.visibility = View.VISIBLE
                return@setOnClickListener
            }

            val textoAGuardar = "$palabraEspanol:$palabraIngles\n"

            try {
                openFileOutput(fileName, MODE_APPEND).use {
                    it.write(textoAGuardar.toByteArray())
                }
                etEspanol.text.clear()
                etIngles.text.clear()
                tvMensaje.setTextColor(resources.getColor(android.R.color.holo_green_dark))
                tvMensaje.text = "Palabras agregadas con éxito"
                tvMensaje.visibility = View.VISIBLE
            } catch (e: IOException) {
                e.printStackTrace()
                tvMensaje.setTextColor(resources.getColor(android.R.color.holo_red_dark))
                tvMensaje.text = "Error al guardar las palabras"
                tvMensaje.visibility = View.VISIBLE
            }
        }

        btnRegresar.setOnClickListener {
            val intent = Intent(this, DicActivity::class.java)
            startActivity(intent)
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun leerArchivo(): String {
        return try {
            openFileInput(fileName).bufferedReader().useLines { lines ->
                lines.joinToString("\n")
            }
        } catch (e: IOException) {
            e.printStackTrace()
            ""
        }
    }
}
