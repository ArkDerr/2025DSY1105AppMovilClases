//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val nuevoVehiculo = Vehiculo("kia","Soluto",2025)

    println(nuevoVehiculo.marca)

    nuevoVehiculo.marca = "Tesla"

    println(nuevoVehiculo.marca)

    println(nuevoVehiculo.toString())

    println(nuevoVehiculo.valorVenta(100,10))


    val nuevoVehiculo1 = vehiculo1("Mazda","rx8",2000)

    println("Esta es la marca del vehiculo 1: $nuevoVehiculo1.marca")
    println(nuevoVehiculo1.toString())
   println(nuevoVehiculo1.valorVenta(1000,500))

    val nuevoVehiculoElectrico = VehiculoElectrico("Tesla","F1",2025,60)
    println(nuevoVehiculoElectrico.toString())

    println("La capacidad actual de carga es: ${nuevoVehiculoElectrico.cargarVehiculo(20)}")

    try {
        val ValorCuota = nuevoVehiculoElectrico.ValorCuota(1000,2)
        println("El valor de la cuota es: ${ValorCuota}")
    } catch (e: Exception) {
        println("No se puede efectuar el calculo")
    } finally {
        println("Se ejecuto la funcion calculo de valor cuota")
    }

    val resultadoExitoso = nuevoVehiculoElectrico.ValorCuotaResult(1000,4)
    val resultadoFallido = nuevoVehiculoElectrico.ValorCuotaResult(1000,0)

    resultadoExitoso
        .onSuccess { valor -> println("El valor de la cuota es: $valor")}
        .onFailure { error -> println("Error: ${error.message}") }

    resultadoFallido
        .onSuccess { valor -> println("El valor de la cuota es: $valor")}
        .onFailure { error -> println("Error: ${error.message}") }

}