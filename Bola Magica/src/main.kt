//Declaramos los valores de nuestras respuestas
const val RESPUESTA_AFIRMATIVA = "SI"
const val   RESPUESTA_NEGATIVA = "NO"
const val RESPUESTA_DUDOSA = "?"

//Unimos las respuestas con los valores
val respuestas = mapOf(
    "Si" to RESPUESTA_AFIRMATIVA,
    "Es cierto" to RESPUESTA_AFIRMATIVA,
    "Totalmente" to RESPUESTA_AFIRMATIVA,
    "Sin duda" to RESPUESTA_AFIRMATIVA,
    "Pregunta en otro momento" to RESPUESTA_DUDOSA,
    "No puedo decirte en este momento" to RESPUESTA_DUDOSA,
    "Puede que si o puede que no" to RESPUESTA_DUDOSA,
    "No va a suceder" to RESPUESTA_NEGATIVA,
    "No cuentas con ello" to RESPUESTA_NEGATIVA,
    "Definitivamente no" to RESPUESTA_NEGATIVA,
    "No lo creo" to RESPUESTA_NEGATIVA,
    )
fun main (args: Array<String>) {

   var salir = false
   do {
       println("Hola soy tu bola ocho magina creada en Kotlin: cual de estas opciones deseas realziar")
       println("1. Quiero realizar una pregunta")
       println("2. Revisar todas las respuestas")
       println("3. Salir")
       println("")

       val valorIngresado = readLine()

       when (valorIngresado) {
           "1" -> realizarPregunta()
           "2" -> mostrarRespuesta()
           "3" -> salir = true
           else -> mostrarError()
       }
   }while  (!salir)
}

fun realizarPregunta(){
    println("Que pregunta deseas realizar?")
    readLine()
    println("Asi que esa era tu pregunta... La respuesta es: ")
    val respuestaGenerada = respuestas.keys.random()
    println(respuestaGenerada)
}

fun mostrarRespuesta() {

    var salir = false
    do {
        println("Selecciona una opción")
        println("1. Revisar todas las respuestas")
        println("2. Revisar solo las respuestas afirmativas")
        println("3. Revisar solo las respuestas dudosas")
        println("4. Revisar solo las respuestas negativas")
        println("5. Salir")
        println("")
        val opsionIngresada = readLine()

        when (opsionIngresada) {
            "1" -> mostrarRespuestaPorTipo()
            "2" -> mostrarRespuestaPorTipo(tipoDeRespuesta = RESPUESTA_AFIRMATIVA)
            "3" -> mostrarRespuestaPorTipo(tipoDeRespuesta = RESPUESTA_DUDOSA)
            "4" -> mostrarRespuestaPorTipo(tipoDeRespuesta = RESPUESTA_NEGATIVA)
            "5" -> salir = true
            else -> println("Error: Respuesta no valida.")
        }
    } while (!salir)
}

fun mostrarError(){
    println("Error: Opción inexistente, por favor, elija una opción válida")
}

    fun salir(){
    println("Hasta Luego!!")
}
fun mostrarRespuestaPorTipo (tipoDeRespuesta: String = "TODOS"){
    when (tipoDeRespuesta) {
        "TODOS" -> respuestas.keys.forEach {respuesta -> println(respuesta) }

        RESPUESTA_AFIRMATIVA -> respuestas.filterValues { values -> values == RESPUESTA_AFIRMATIVA }.also {
            respuestasPositivas -> println(respuestasPositivas.keys)
        }

        RESPUESTA_NEGATIVA -> respuestas.filterValues { values -> values == RESPUESTA_NEGATIVA }.also {
            respuestasNegativas -> println(respuestasNegativas.keys)
        }

        RESPUESTA_DUDOSA -> respuestas.filterValues { values -> values == RESPUESTA_DUDOSA }.also {
            respuestasDudosas -> println(respuestasDudosas.keys)
        }

        else -> println("Error: Respuesta no valida.")
    }

}
