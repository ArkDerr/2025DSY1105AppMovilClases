class Vehiculo {

    var marca: String = ""
    lateinit var modelo: String
    private var anio: Int = 0

    constructor()

    constructor(marca: String, modelo: String, anio: Int) {
        this.marca = marca
        this.modelo = modelo
        this.anio = anio
    }

    override fun toString(): String {
        return "Vehiculo(marca='$marca', modelo='$modelo', anio=$anio)"
    }

    fun valorVenta(costo: Int, descuento: Int): Int{
        return (costo - descuento)
    }

}