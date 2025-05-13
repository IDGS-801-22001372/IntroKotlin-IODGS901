package com.example.introkotlin_iodgs901.ejemplo2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin_iodgs901.R

class SaludoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_saludo)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtName = findViewById<AppCompatEditText>(R.id.edtName)
        val btnStart = findViewById<AppCompatButton>(R.id.btnStart)

        btnStart.setOnClickListener {
            val nombre = edtName.text.toString().trim()
            if (nombre.isEmpty()) {
                Toast.makeText(this, "Por favor, escribe tu nombre", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "¡Hola, $nombre!", Toast.LENGTH_LONG).show()
            }
        }
    }
}
