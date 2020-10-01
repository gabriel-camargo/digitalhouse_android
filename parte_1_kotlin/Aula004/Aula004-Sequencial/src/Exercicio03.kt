/**
 * Tendo como dado de entrada a altura (h) de uma pessoa, construa um algoritmo que
 * calcule seu peso ideal, utilizando as seguintes fórmulas:
 *
 * Para homens: (72.7 * h) - 58
 * Para mulheres: (62.1 * h) - 44.7
*/

fun main() {
    print("Digite sua altura: ")
    var h: Double = readLine()!!.toDouble()

    var pesoM: Double = (72.7 * h) - 58
    var pesoF: Double = (62.1 * h) - 44.7

    println("Peso ideal para homens:" + "%.2f".format(pesoM))
    println("Peso ideal para mulheres:" + "%.2f".format(pesoF))
}