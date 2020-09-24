package exercicios.collections.ex03

class Prova {
    fun somaTotal(conjuntoInteiros: MutableSet<Int>): Int {
        var total: Int = 0

        conjuntoInteiros.forEach { total+=it }

        return total
    }
}