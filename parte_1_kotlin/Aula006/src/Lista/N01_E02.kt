package Lista

/**
 * 2. Faça um Programa que leia um vetor de 10 números e mostre-os na ordem
* inversa.
 */
fun main() {
    val arrayNumeros = arrayOfNulls<Int>(10)

    for (i in arrayNumeros.indices) {
        print("Digite um número: ")
        arrayNumeros[i] = readLine()!!.toInt()
    }

    arrayNumeros.reverse()
    arrayNumeros.forEach { n -> println(n) }
}