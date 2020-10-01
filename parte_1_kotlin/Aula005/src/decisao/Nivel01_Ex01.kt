package parte01

/**
 * 1. Faça um Programa que verifique se uma letra digitada é "F" ou "M". Conforme a
 * letra escrever: F - Feminino, M - Masculino, Sexo Inválido.
 */

fun main() {
    print("Digite um sexo biológico (F ou M): ")
    val sexo = readLine()!!

    when(sexo) {
        "F" -> println("Feminino")
        "M" -> println("Masculino")
        else -> {
            println("Valor inválido.")
        }
    }
}