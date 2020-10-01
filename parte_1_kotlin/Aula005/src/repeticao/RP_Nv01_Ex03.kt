import kotlin.math.max
import kotlin.math.min

//Faça um programa que receba dois números inteiros e gere os números inteiros
//que estão no intervalo compreendido por eles.

fun main() {

    print("Digite o 1º número: ")
    val num1 = readLine()!!.toInt()

    print("Digite o 2º número: ")
    val num2 = readLine()!!.toInt()

    for(i in min(num1, num2)..max(num1, num2)) {
        println(i)
    }

}