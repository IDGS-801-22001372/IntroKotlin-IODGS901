package com.example.introkotlin_iodgs901

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin_iodgs901.cinepolis.CinepolisActivity
import com.example.introkotlin_iodgs901.diccionario.DicActivity as DiccionarioMenuActivity
import com.example.introkotlin_iodgs901.operaciones.OperacionesActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnCinepolis = findViewById<Button>(R.id.btnCinepolis)
        val btnDiccionario = findViewById<Button>(R.id.btnDiccionario)
        val btnOperaciones = findViewById<Button>(R.id.btnOperaciones)

        btnCinepolis.setOnClickListener {
            val intent = Intent(this, CinepolisActivity::class.java)
            startActivity(intent)
        }

        btnDiccionario.setOnClickListener {
            val intent = Intent(this, DiccionarioMenuActivity::class.java)
            startActivity(intent)
        }

        btnOperaciones.setOnClickListener {
            val intent = Intent(this, OperacionesActivity::class.java)
            startActivity(intent)
        }
    }
}
