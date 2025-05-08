package com.example.introkotlin_iodgs901.KotlinTemas

fun main(){
    val d:Int

    val e=true

    if(e){
        d=1
    }else{
        d=2
    }
    println(d)
    val numero=if(e) 1 else 2
    println(numero)
    //--------------
    print("Ingrese el suelde del empleado:")
    val sueldo= readln().toDouble()
    if (sueldo > 3000){
        println("Debe pagar impuestos")
    }else{
        println("No debe pagar impuestos")
    }
    //when
    val objeto:Any="Hola"
    when(objeto){
        "1"-> println("Es un uno")
        "Hola"-> println("Es un String")
        else-> println("No se que es")
    }
    //rage
    1..4
    4 downTo 1
    1..10 step 2
    'a'..'b'

}