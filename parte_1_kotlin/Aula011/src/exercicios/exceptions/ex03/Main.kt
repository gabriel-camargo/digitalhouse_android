package exercicios.exceptions.ex03

import java.lang.ArithmeticException

fun main() {
    val calculadora = CalculaMatematico()

    try {
        println(calculadora.divisao(4,0))
    } catch(ex: ArithmeticException) {
        println(ex)
    }
}