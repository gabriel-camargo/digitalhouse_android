/**
 * 1. Faça um Programa que peça as 4 notas bimestrais e mostre a média.
 */

fun main() {
    print("Digite a nota 1: ")
    var nota1: Double = readLine()!!.toDouble()

    print("Digite a nota 2: ")
    var nota2: Double = readLine()!!.toDouble()

    print("Digite a nota 3: ")
    var nota3: Double = readLine()!!.toDouble()

    print("Digite a nota 4: ")
    var nota4: Double = readLine()!!.toDouble()

    var media:Double = (nota1 + nota2 + nota3 + nota4) / 4

    println("A média é: $media")
}