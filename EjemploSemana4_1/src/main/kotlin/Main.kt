package cl.duoc

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

//DataClass para modelos de negocio, dto, entidades de BD
data class Usuario(var nombre: String, var email:String) //crea una clase con tostring, equals y hashCode // Se unas cuando una clase no contiene logica.

fun main() {
    //Scope Functions: se usan para evitar código repetitivo. Evita llamar al metodo set de la clase.

    val usuario = Usuario("Daniel","daniel@mail.cl")

    //Apply configura un objeto y devuelve un objeto
    val usuarioConfig = usuario.apply {
        nombre = nombre.uppercase()
        email = "nuevo.$email"
    }

    //let ejecuta código y devuelve el ultimo valor del bloque Funciona como un return
    val longitudNombre = usuario.let {
        println("Usuario: ${it.nombre}, Email: ${it.email}")
        it.nombre.length
    }

    println(usuario)
    println(usuarioConfig)
    println("Longitud del nombre: $longitudNombre")

    //Sealed Class: clases que restringen la herancia a un conjunto de subclases conocidas. Se usas para manejar estados y resultados
    println(manejarResultado(Resultado.Cargando))
    println(manejarResultado(Resultado.Exito("Usuario logueado")))
    println(manejarResultado(Resultado.Error("Sin conexión")))

    val numero : Int = readln().toIntOrNull()?:1
    println(numero)


}

sealed class Resultado {
    data class Exito(val datos: String) : Resultado()
    data class Error(val mensaje: String) : Resultado()
    object Cargando : Resultado()
}

fun manejarResultado(res: Resultado) = when (res) {
    is Resultado.Exito -> "✅ Datos: ${res.datos}"
    is Resultado.Error -> "❌ Error: ${res.mensaje}"
    Resultado.Cargando -> "⏳ Cargando..."
}

