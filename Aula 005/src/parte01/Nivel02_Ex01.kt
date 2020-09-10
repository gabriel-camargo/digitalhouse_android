/**
 * Faça um Programa para um caixa eletrônico. O programa deverá perguntar ao
 * usuário a valor do saque e depois informar quantas notas de cada valor serão ornecidas. As notas disponíveis serão as de 1, 5, 10, 50 e 100 reais. O valor
 * mínimo é de 10 reais e o máximo de 600 reais. O programa não deve se preocupar
 * com a quantidade de notas existentes na máquina.
 *
 * Exemplo 1: Para sacar a quantia de 256 reais, o programa fornece duas notas de
 * 100, uma nota de 50, uma nota de 5 e uma nota de 1;
 *
 * Exemplo 2: Para sacar a quantia de 399 reais, o programa fornece três notas de
 * 100, uma nota de 50, quatro notas de 10, uma nota de 5 e quatro notas de 1.
 */

fun main() {
    print("Informe o valor a ser sacado: ")
    val saque = readLine()!!.toDouble()

    val notas100 = (saque / 100).toInt()
    val restoSemNotas100 = (saque % 100)

    val notas50 = (restoSemNotas100 / 50).toInt()
    val restoSemNotas50 = (restoSemNotas100 % 50)

    val notas10 = (restoSemNotas50 / 10).toInt()
    val restoSemNotas10 = (restoSemNotas50 % 10)

    val notas5 = (restoSemNotas10 / 5).toInt()
    val notas1 = (restoSemNotas10 % 5).toInt()

    if(notas100 > 0) println("$notas100 notas de 100")
    if(notas50 > 0) println("$notas50 notas de 50")
    if(notas10 > 0) println("$notas10 notas de 10")
    if(notas5 > 0) println("$notas5 notas de 5")
    if(notas1 > 0)  println("$notas1 notas de 1")
}