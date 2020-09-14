package Lista

/**
 * 3. Faça um Programa que peça a altura de 5 pessoas, armazene cada informação
 * num array. Imprima a altura na ordem inversa a ordem lida
 */

fun main() {
    val arrayAltura = arrayOfNulls<Double>(5)

    for (i in arrayAltura.indices) {
        print("Digita a altura: ")
        arrayAltura[i] = readLine()!!.toDouble()
    }

    arrayAltura.reverse()
    arrayAltura.forEach { altura -> println("%.2f".format(altura)) }
}