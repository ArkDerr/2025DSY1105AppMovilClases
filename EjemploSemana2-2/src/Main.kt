//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    //Colecciones
    /*
    Existen 3 tipos:
    Listas (List): Colecciones ordenadas que pueden contener elementos duplicados.
        listOf (inmutable)
        mutableListOf (Mutable)
    Conjuntos (Set): Colecciones de elementos únicos que no permniten duplicados.
        setOf (inmutable)
        mutableSetOf (Mutable)
    Mapas (Map): Colecciones de pares clave-valor que asocian claves únicas con valores.
        mapOf (inmutable)
        mutableMapOf (Mutable solo en valores)
     */

    //List
    val frutas = listOf("Manzana","Platano","Pera","Manzana")
    println("Lista de frutas $frutas")

    val numeros = mutableListOf(1,2,3,2)
    numeros.add(4)
    println("Lista de numeros $numeros")

    //Set (Elimina valores duplicados de manera automatica)
    val colores = setOf("Rojo","Verde","Azul","Rojo")
    println("Set de colores $colores")

    val edades = mutableSetOf(18,25,30)
    edades.add(50)
    println("Set de edades $edades")

    //Map
    val telefonos = mapOf(
        "Daniel" to "123456",
        "Maria" to "987654",
        "Juan" to "456781"
    )
    println("Telefonos: $telefonos")

    val inventario = mutableMapOf("Sillas" to 10, "mesas" to 5)
    inventario["Lapices"] = 30
    inventario["Cuadernos"]= 70
    inventario["Sillas"] = 20
    println("Inventario: $inventario")

    //val
    //frutas =

    //Filtrado. Crear una nueva coleccion solo con elementos que cumplen una condición
    val nuevosNumeros = numeros.filter{ it >= 3 }
    println(nuevosNumeros)

    //Mapeo. Transforma cada elemento de una coleción en otra de igual tamaño.
    val nuevasEdades = edades.map { it + 5 }
    println(edades)
    println(nuevasEdades)

    //Reducción. Combina todos los elementos en una coleccion de un solo valor. acc acumulador parte con el primer valor
    val sumaNumeros = numeros.reduce { acumulador, elemento -> acumulador + elemento  }
    println(numeros)
    println(sumaNumeros)

    val palabras = listOf("Hola","Kotlin","Duoc")
    val frase = palabras.reduce { acc, palabra -> "$acc $palabra" }
    println(frase)

    val sumaNumeros2 = numeros.fold(10) {acc, num -> acc + num}
    println(numeros)
    println(sumaNumeros2)

    //Buscar en colecciones find (primero que cumple), first, last
    val buscar = numeros.find { it >= 0 }
    println(buscar)

    val nombres = listOf("Maria","Mario","Juan","Luisa")
    val buscarNonmbre = nombres.find { it.startsWith("m") }
    println(buscarNonmbre)

    //Ejercicio:
    
}