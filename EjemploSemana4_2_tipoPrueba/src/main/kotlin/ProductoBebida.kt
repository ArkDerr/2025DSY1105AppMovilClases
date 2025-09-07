package cl.duoc

class ProductoBebida  (index: Int, nombreProducto: String, precioProducto: Int, private var tamañoProductoBebida: String) : Producto(index,nombreProducto,precioProducto){

    override fun toString(): String {
        val toString = super.toString()
        return "${toString}, ProductoBebida(tamañoProductoBebida='$tamañoProductoBebida')"
    }
}
