/**
 * 2- Faça um Programa que pergunte quanto você ganha por hora e o número de horas
 * trabalhadas no mês. Calcule e mostre o total do seu salário no referido mês.
 */

fun main() {
    print("Quanto vale sua hora? ")
    var valorHora: Double = readLine()!!.toDouble()

    print("Quantas horas você trabalhou neste mês? ")
    var horasTrabalhadas: Int = readLine()!!.toInt()

    var salario = valorHora * horasTrabalhadas

    println("Seu salário do mês é: R$ $salario")
}