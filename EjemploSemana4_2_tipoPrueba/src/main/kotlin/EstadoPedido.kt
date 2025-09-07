package cl.duoc

import kotlinx.coroutines.delay

class EstadoPedido {

    suspend fun estado(): String= "Estado: En Preparación..."


    suspend fun pedido(opcionesProductos: MutableList<Int>, productos: MutableSet<Producto>) {
        delay(1000)
        for (pedido in opcionesProductos){
            for (producto in productos){
                if (pedido == producto.index){
                    println("- ${producto.nombreProducto}: ${producto.precioProducto}")
                }
            }
        }
    }

}