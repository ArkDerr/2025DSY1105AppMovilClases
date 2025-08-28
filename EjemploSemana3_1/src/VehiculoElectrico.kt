import java.lang.IllegalArgumentException

class VehiculoElectrico (marca: String, modelo: String, anio: Int, var capacidadCarga: Int): vehiculo1(marca, modelo, anio) {

    override fun toString(): String {
        val Vehiculo1 = super.toString()
        return "VehiculoElectrico(capacidadCarga=$capacidadCarga), del vehiculo: $Vehiculo1"
    }

    fun cargarVehiculo(cargaEnchufe:Int):Int {
        return capacidadCarga + cargaEnchufe
    }

    fun ValorCuota(valorVehiculo:Int, numCuotas:Int):Int {
        return valorVehiculo / numCuotas
    }

    fun ValorCuotaResult(valorVehiculo:Int, numCuotas:Int): Result<Int> {
        return if (numCuotas == 0 ){
            Result.failure(exception = IllegalArgumentException("El divisor no puede ser cero"))
        } else {
            Result.success(valorVehiculo / numCuotas)
        }
    }

}