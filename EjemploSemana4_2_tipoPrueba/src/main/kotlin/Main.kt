package cl.duoc

import kotlinx.coroutines.*
import kotlin.math.round
import kotlin.math.roundToInt

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() = runBlocking {

    val gestor = GestorPedidos()
    val estado = EstadoPedido()

    val hamburguesaClasica = ProductoComida(1,"Hamburguesa Clasica", 8990, false)
    val salmonGrillado = ProductoComida(2,"Salmon Grillado", 15990, true)
    val cocaCola = ProductoBebida(3,"Coca Cola", 1990, "Mediano")
    val jugoNatural = ProductoBebida(4,"Jugo Natural", 2990, "Grande")

    val productos = mutableSetOf<Producto>()
    productos.add(hamburguesaClasica)
    productos.add(salmonGrillado)
    productos.add(cocaCola)
    productos.add(jugoNatural)

    var subTotal = 0
    var subTotal2 = 0
    var descuento = 0
    var iva = 0
    var total = 0



    println(productos)

    println("===== SISTEMA FOODEXPRESS =====")
    println("1. ${hamburguesaClasica.nombreProducto} - ${hamburguesaClasica.precioProducto}")
    println("2. ${salmonGrillado.nombreProducto} - ${salmonGrillado.precioProducto}")
    println("3. ${cocaCola.nombreProducto} - ${cocaCola.precioProducto}")
    println("4. ${jugoNatural.nombreProducto} - ${jugoNatural.precioProducto}")
    println()
    print("Seleccione productos (numeros separados por coma): ")
    val ingresoOpciones: String = readln()

    val opcionesProductos = ingresoOpciones.split(",").map { it.toInt() }.toMutableList()

    print("Cliente tipo (regular/vip/premiun): ")
    val ingresoclienteTipo = readln()

    println(opcionesProductos)
    println(ingresoclienteTipo)

    val calcular = launch {
        println(estado.estado())
        estado.pedido(opcionesProductos,productos)

        subTotal = gestor.subTotalPedido(opcionesProductos,productos)
        println("Subtotal: $${subTotal}")

        if (ingresoclienteTipo.equals("regular")){
            descuento = manejarResultado(Descuento.Regular(subTotal))
            subTotal2 = subTotal - descuento
        } else if (ingresoclienteTipo.equals("vip")){
            descuento = manejarResultado(Descuento.Vip(subTotal))
            subTotal2 = subTotal - descuento
        } else {
            descuento = manejarResultado(Descuento.Premiun(subTotal))
            subTotal2 = subTotal - descuento
        }

        println("Descuento ${ingresoclienteTipo}: -$ ${descuento}")

        iva = gestor.calculoImpuesto(subTotal2)
        println("IVA: $${iva}")

        total = gestor.total(subTotal2, iva)
        println("TOTAL: $ ${total}")


    }
}

sealed class Descuento {
    data class Regular(val subTotal: Int) : Descuento()
    data class Vip(val subTotal: Int) : Descuento()
    data class Premiun(val subTotal: Int) : Descuento()

}

fun manejarResultado(desc: Descuento): Int = when (desc) {
    is Descuento.Regular -> (desc.subTotal * 0.05).roundToInt()
    is Descuento.Vip -> (desc.subTotal * 0.1).roundToInt()
    is Descuento.Premiun -> (desc.subTotal * 0.15).roundToInt()
}