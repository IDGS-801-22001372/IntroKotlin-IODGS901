package com.example.introkotlin_iodgs901.KotlinTemas

fun main() {
    var numero: Int

    do {
        println("Ingrese un numero")
        numero = readLine()!!.toInt()

        if (numero > 0) {
            for (i in 1..numero) {
                println("*".repeat(i))
            }
        }

    } while (numero != 0)
}