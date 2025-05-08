package com.example.introkotlin_iodgs901.KotlinTemas

fun main(){
    println("Ingresa el valor de a:")
    val a = readLine()!!.toDouble()
    println("Ingresa el valor de b:")
    val b = readLine()!!.toDouble()
    println("Ingresa el valor de c:")
    val c = readLine()!!.toDouble()

    val numero = b * b - 4 * a * c

    if (a == 0.0) {
        println("No es una ecuacion cuadratica (a no puede ser 0).")
    } else if (numero > 0) {
        val x1 = (-b + Math.sqrt(numero)) / (2 * a)
        val x2 = (-b - Math.sqrt(numero)) / (2 * a)
        println("Raices reales y diferentes: x1 = $x1, x2 = $x2")
    } else if (numero == 0.0) {
        val x = -b / (2 * a)
        println("Raices reales e iguales: x = $x")
    } else {
        println("No tiene raices reales.")
    }

}