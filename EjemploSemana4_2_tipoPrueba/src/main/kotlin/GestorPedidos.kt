package cl.duoc

import kotlin.math.round

class GestorPedidos {

    suspend fun subTotalPedido (opcionesProductos: MutableList<Int>, productos: MutableSet<Producto>) : Int{
        var subTotal: Int = 0
        for (pedido in opcionesProductos) {
            for (producto in productos) {
                if (pedido == producto.index) {
                    subTotal = subTotal + producto.precioProducto
                }
            }
        }
        return subTotal
    }

    fun calculoImpuesto (subtotal: Int) : Int {
        var iva: Int = 0
        iva = round(subtotal * 0.19).toInt()
        return iva
    }


    fun total (subtotal: Int, iva: Int) : Int {
        val total = subtotal + iva
        return total
    }

}