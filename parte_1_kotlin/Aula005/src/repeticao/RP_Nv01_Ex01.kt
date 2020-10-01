import kotlin.math.max

/**
 * Faça um programa que leia 5 números e informe o maior número.
 */

fun main() {

    var maiorNum = 0
    var numEntrada = 0

    for(i in 1..5) {
        print("Digite o $i º número: ")
        numEntrada = readLine()!!.toInt()

        maiorNum = max(maiorNum, numEntrada)
    }

    println("O maior número é: $maiorNum")
}