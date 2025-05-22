package com.example.introkotlin_iodgs901.cinepolis

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.introkotlin_iodgs901.R

class CinepolisActivity : AppCompatActivity() {

    // precio
    private val PRECIO_BOLETO = 12.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cinepolis)

        val calculateButton: Button = findViewById(R.id.calculateButton)
        calculateButton.setOnClickListener {
            calcularTotal()
        }
    }

    private fun calcularTotal() {
        val nameEditText: EditText = findViewById(R.id.nameEditText)
        val buyersEditText: EditText = findViewById(R.id.buyersEditText)
        val ticketsEditText: EditText = findViewById(R.id.ticketsEditText)
        val yesRadioButton: RadioButton = findViewById(R.id.yesRadioButton)
        val noRadioButton: RadioButton = findViewById(R.id.noRadioButton)
        val paymentTextView: TextView = findViewById(R.id.paymentTextView)

        if (nameEditText.text.isEmpty() || buyersEditText.text.isEmpty() || ticketsEditText.text.isEmpty()) {
            Toast.makeText(this, "completa los campos", Toast.LENGTH_SHORT).show()
            return
        }

        val compradores = buyersEditText.text.toString().toInt()
        val boletos = ticketsEditText.text.toString().toInt()
        val tieneTarjeta = yesRadioButton.isChecked

        // validaciones de boletos
        if (boletos > compradores * 7) {
            Toast.makeText(this, "limite exedido", Toast.LENGTH_LONG).show()
            return
        }

        // total
        var total = boletos * PRECIO_BOLETO

        // descuentos
        total = if (boletos > 5) {
            val descuento = total * 0.15
            total - descuento
        } else if (boletos in 3..5) {
            val descuento = total * 0.10
            total - descuento
        } else {
            total
        }

        // descuento tarjeta
        if (tieneTarjeta) {
            val descuentoTarjeta = total * 0.10
            total -= descuentoTarjeta
        }

        paymentTextView.text = "$${"%,.2f".format(total)}"

        Toast.makeText(this, "Compra exitosa", Toast.LENGTH_SHORT).show()

        // reinicia
        //nameEditText.text.clear()
        //buyersEditText.text.clear()
        //ticketsEditText.text.clear()
        //noRadioButton.isChecked = true
        //paymentTextView.text = "$0.00"
    }
}