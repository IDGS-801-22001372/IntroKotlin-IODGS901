package com.example.introkotlin_iodgs901.KotlinTemas

fun main(){

    //for
    for(number in 1..10){
        println(number)
    }
    val nombres = listOf("Juan", "Pedro", "Maria")

    for (nombre in nombres){
        println(nombre)
    }

    //while do while
    var x = 0
    while(x < 5){
        println(x)
        x++
    }

    do {
        println(x)
        x++
    }while(x < 5)

}