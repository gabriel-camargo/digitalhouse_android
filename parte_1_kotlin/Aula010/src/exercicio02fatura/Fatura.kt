package exercicio02fatura

class Fatura {
    val listaItens = ArrayList<Item>()

    fun getTotalFatura() = listaItens.sumOf { (it.getPreco * it.getQtdComprada) }
}