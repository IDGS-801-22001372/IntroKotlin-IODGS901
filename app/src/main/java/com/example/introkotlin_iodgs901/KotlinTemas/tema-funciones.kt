package com.example.introkotlin_iodgs901.KotlinTemas

fun saludo(){
    return println("Hola mundo")
}

fun sum(x:Int, y:Int):Int{
    return x+y
}

fun sum(x: Int, y: Int, z: Int) = x + y

fun main(){
    saludo()
    println("--------------------------------------------")
    println(sum(1,2))
    println(sum(1,2,3))
}