package exercicios.exceptions.ex01

import java.lang.IndexOutOfBoundsException

fun main() {
    val array: ArrayList<String> = ArrayList<String>()

    array.add("Pato")
    array.add("Cachorro")
    array.add("Gato")

    try {
        println(array[3])
    } catch (ex: IndexOutOfBoundsException) {
        ex.printStackTrace()
    }
}