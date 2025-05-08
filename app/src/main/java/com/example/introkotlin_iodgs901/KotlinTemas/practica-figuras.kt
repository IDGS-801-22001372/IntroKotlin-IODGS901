package com.example.introkotlin_iodgs901.KotlinTemas

//circulo, pantagono, triangulo

fun main() {

    var opcion: Int

    do {
        println(
            "Menu de figuras: " +
                    "\n1. Circulo" +
                    "\n2. Pentagono" +
                    "\n3. Triangulo" +
                    "\n4. Salir"
        )
        print("Selecciona una opcion: ")

        val inputString = readLine()

        opcion = inputString?.toIntOrNull() ?: 0

        when (opcion) {
            1 -> caluclarAreaCirculo()
            2 -> caluclarAreaPentagono()
            3 -> caluclarAreaTriangulo()
            4 -> println("Saliendo...")
            else -> println("Opcion no valida.")
        }

    } while (opcion != 4)
}

fun caluclarAreaCirculo() {
    println("\n--- area del circulo ---")
    print("Introduce el radio del circulo: ")
    val radio = readLine()?.toDoubleOrNull()

    if (radio != null) {
        val pi = 3.14159
        val area = pi * radio * radio
        println("El area del circulo es: $area")
    } else {
        println("Dato invalido")
    }
}

fun caluclarAreaPentagono() {
    println("\n--- area del pentagono---")
    print("Introduce el lado: ")
    val lado = readLine()?.toDoubleOrNull()

    print("Introduce el apotema: ")
    val apotema = readLine()?.toDoubleOrNull()

    if (lado != null && apotema != null) {
        val perimetro = 5 * lado
        val area = (perimetro * apotema) / 2
        println("El area del triangulo es: $area")
    } else {
        println("Dato invalido")
    }
}

fun caluclarAreaTriangulo() {
    println("\n--- area del triangulo---")
    print("Introduce la base: ")
    val base = readLine()?.toDoubleOrNull()

    print("Introduce la altura: ")
    val altura = readLine()?.toDoubleOrNull()

    if (base != null && altura != null) {
        val area = (base * altura) / 2
        println("El area del triangulo es: $area")
    } else {
        println("Dato invalido")
    }
}