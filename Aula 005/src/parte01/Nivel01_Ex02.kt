/**
 * Faça um Programa que peça um número inteiro e determine se ele é par ou
 * ímpar. Dica: utilize o operador módulo (resto da divisão).
 */

fun main() {
    print("Digite um número inteiro: ")
    val num = readLine()!!.toInt()

    if(num%2 == 0) {
        println("O número é par!")
    } else {
        println("O número é impar!")
    }
}