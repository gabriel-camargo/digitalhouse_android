package exercicios.collections.ex02

fun main() {
    val lista = mutableListOf<Int>()

    lista.add(1)
    lista.add(5)
    lista.add(5)
    lista.add(6)
    lista.add(7)
    lista.add(8)
    lista.add(8)
    lista.add(8)

    lista.forEach {
        println(it)
    }

    println("-------------")

    val conjunto = mutableSetOf<Int>()

    conjunto.add(1)
    conjunto.add(5)
    conjunto.add(5)
    conjunto.add(6)
    conjunto.add(7)
    conjunto.add(8)
    conjunto.add(8)
    conjunto.add(8)

    conjunto.forEach {
        println(it)
    }
}