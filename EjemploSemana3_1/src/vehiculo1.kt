open class vehiculo1 (private var marca:String, var modelo:String, var anio:Int){

    override fun toString(): String {
        return "Vehiculo(marca='$marca', modelo='$modelo', anio=$anio)"
    }

    fun valorVenta(costo: Int, descuento: Int): Int{
        return (costo - descuento)
    }

}