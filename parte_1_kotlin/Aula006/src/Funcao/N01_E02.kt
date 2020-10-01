package Funcao

/**
 * 2. Faça um programa, com uma função que necessite de um argumento. A função
 * retorna o valor de caractere ‘P’, se seu argumento for positivo, e ‘N’, se seu
 * argumento for zero ou negativo.
 */

fun main () {
    println(ehPositivo(3))
    println(ehPositivo(0))
    println(ehPositivo(-1))
}

fun ehPositivo (numero:Int) = if (numero > 0) 'P' else 'N'