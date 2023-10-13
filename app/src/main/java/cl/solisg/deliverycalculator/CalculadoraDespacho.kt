package cl.solisg.deliverycalculator

import java.util.Scanner

object CalculadoraDespacho {

    fun calcularCostoDespacho(montoCompra: Int, distancia: Int): Int {
        if (montoCompra > 50000) {
            return if (distancia <= 20) 0 else (distancia - 20) * 150
        } else if (montoCompra >= 25000 && montoCompra <= 49999) {
            return distancia * 150
        } else {
            return distancia * 300
        }
    }
}

fun main() {
    val input = Scanner(System.`in`)

    println("Bienvenido a la aplicación de despacho a domicilio.")

    print("Ingrese el monto total de la compra en pesos: ")
    val montoCompra = input.nextInt()

    print("Ingrese la distancia en kilómetros hasta su domicilio: ")
    val distancia = input.nextInt()

    val costoDespacho = CalculadoraDespacho.calcularCostoDespacho(montoCompra, distancia)

    println("El costo de despacho a domicilio es: \$$costoDespacho")

    input.close()
}
