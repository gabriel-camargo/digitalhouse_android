package exercicios.collections.ex03

fun main() {
    val notas = mutableSetOf<Int>()
    val provas = Prova()

    notas.add(10)
    notas.add(5)
    notas.add(20)

    notas.forEach{
        println(it)
    }

    println("Total: ${provas.somaTotal(notas)}")
}