package cl.duoc

open class Producto (var index: Int, var nombreProducto: String, var precioProducto: Int){

    override fun toString(): String {
        return "Producto(nombreProducto='$nombreProducto', precioProducto=$precioProducto)"
    }
}