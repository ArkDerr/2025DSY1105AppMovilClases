package cl.duoc

class ProductoComida (index: Int, nombreProducto: String, precioProducto: Int, private var esPremiun: Boolean) : Producto(index,nombreProducto,precioProducto){

    override fun toString(): String {
        val toString = super.toString()
        return "${toString}, (tipoProductoComida='$esPremiun')"
    }
}