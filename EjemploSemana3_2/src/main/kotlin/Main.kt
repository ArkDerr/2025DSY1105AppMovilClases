package org.example

import kotlinx.coroutines.*
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() = runBlocking{

    println("Inicio de APP")

/*
val result = obtenerDatos()
println(result)
*/

  val job = launch {
      val result = obtenerDatos()
      println(result)
  }

    /*
    val job2 = launch {
        val resultSuma = sumaLenta(5,8)
        println(resultSuma)
    }

     */

    val resultSuma = async {sumaLenta( 5,8)}
    //println(resultSuma)

    val job3 = launch {
        println("Funcion 1")
    }

    val job4 = launch {
        delay(6000)
        println("Funcion 2")
    }

    job3.join()
    job4.join()
    println("El resultado de la suma lenta con promesa es: " + resultSuma.await())


println("Fin de rutina")
}

suspend fun obtenerDatos(): String{
println("Inicio de la descarga de datos")
delay(10000)
return "Datos Descargados"
}

suspend fun sumaLenta(a: Int,b: Int): Int{
    delay(5000)
    return a+b
}