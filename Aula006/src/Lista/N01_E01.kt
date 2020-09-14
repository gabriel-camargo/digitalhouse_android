package Lista

/**
 * 1. Faça um Programa que leia um vetor de 5 números inteiros e mostre-os.
 */

fun main() {
    val arrayNumeros = arrayOfNulls<Int>(5)

    for (i in arrayNumeros.indices) {
        print("Digite um número: ")
        arrayNumeros[i] = readLine()!!.toInt()
    }

    arrayNumeros.forEach { n -> println(n) }
}