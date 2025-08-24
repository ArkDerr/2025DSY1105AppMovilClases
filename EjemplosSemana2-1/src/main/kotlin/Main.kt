package org.example

import jdk.dynalink.Operation

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    //Variable que puede ser nulla agregando ?
    var a: String? = "HOLA"
    println(a)
    a = null
    println(a)

    //Acceso Seguro
    val lengthSafe = a?.length
    println(lengthSafe)

    //acceso forzado (puede lanzar la excepción)
    //val lengthSafeforce = a!!.length
    println(lengthSafe)

    //IF y When (switch en java)
    var y: Int = 100
    var z: Int = 200

    if (y<z){
        println("Y es menor que Z")
    } else if (y==z){
        println("Las variables Y y Z con iguales")
    } else {
        println("Z es menor que Y")
    }

    var c: Int = 3

    when (c){
        1 -> println("C vale 1")
        2 -> println("C vale 2")
        else -> println("C no es 1 ni 2")
    }

    //For en Kotlin
    //Rango de numeros
    for (i in 1..5){
        println(i)
    }

    println("##########################")

    //Excluye el ultimo valor
    for (i in 1 until 5){
        println(i)
    }

    println("##########################")
    //Orden descendente
    for (i in 5 downTo 1){
        println(i)
    }

    println("##########################")
    //Usando salto
    for (i in 0..10 step 2){
        println(i)
    }

    println("##########################")
    //Recorrer un array o lista
    val frutas = listOf("manzana","platano","naranja")

    for (fruta in frutas){
        println(fruta)
    }

    println("##########################")
    //Recorrer con indices
    val numeros = arrayOf(10,20,30)

    for (i in numeros.indices){
        println("Indice $i: ${numeros[i]}")
    }

    println("##########################")
    for ((indice, valor) in numeros.withIndex()){
        println("Indice $indice: $valor")
    }

    println("##########################")
    //While
    var i = 1
    while (i<=10){
        println(i)
        i++
    }

    println("##########################")
    //do-While
    var w = 1
    do {
        println(w)
        w++
    } while (w<=10)

    //Funciones
    println(sum(1,2))
    println(sum2(3,4))
    println(calculate(5,6,::sum2))
    println(sum3(7,8))

}

//Sintaxis tradicional
fun sum(a: Int, b:Int): Int {
    return a+b
}

//de una solo expresion: Kotlin elige el tipo de retorno
fun sum2(a: Int,b: Int) = a+b

//Orden Superior. recibe funcio como parametro
fun calculate(x:Int,y:Int, operation: (Int,Int)->Int):Int{
    return operation(x,y)
}

//Lambda o anonima. Funcion sin nombre que puede almacenar en una variable
val sum3 = {a:Int , b:Int -> a+b}
