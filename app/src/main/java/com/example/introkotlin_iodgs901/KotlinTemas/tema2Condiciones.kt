package com.example.introkotlin_iodgs901.KotlinTemas

fun main() {
    /*
    List, MutableList
    Set, MutableSet
    Map, MutableMap
     */

    var readOnlyList: List<String> = listOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes")
    println(readOnlyList)
    println("El primer dia es ${readOnlyList[0]}")
    println("El primer dia es ${readOnlyList.first()}")
    println("El numero de dias es ${readOnlyList.count()}")
    println("Martes" in readOnlyList)
    var figuras: MutableList<String> = mutableListOf("Circulo", "Cuadrado", "Triangulo")
    println(figuras)
    figuras.add("Pentagono")
    println(figuras)
    figuras.removeAt(0)



}