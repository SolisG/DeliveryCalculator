package cl.solisg.deliverycalculator

object ConversorGradosRadianes {
    fun gradosARadianes(grados: Double): Double {
        return grados * Math.PI / 180.0
    }
}

fun main() {
    val input = java.util.Scanner(System.`in`)

    println("Bienvenido al conversor de grados a radianes.")

    print("Ingrese el número de grados a convertir: ")
    val grados = input.nextDouble()

    val radianes = ConversorGradosRadianes.gradosARadianes(grados)
    println("El resultado en radianes es: $radianes")

    input.close()
}
