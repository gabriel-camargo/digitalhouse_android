package exercicio02fatura

fun main() {
    val fatura = Fatura()

    fatura.listaItens.add(Item(1, "Teste 1", 5, 100.0))
    fatura.listaItens.add(Item(2, "Teste 2", 6, 125.0))
    fatura.listaItens.add(Item(3, "Teste 3", -1, 50.0))
    fatura.listaItens.add(Item(4, "Teste 4", 5, -50.0))
    fatura.listaItens.add(Item(5, "Teste 5", -5, -50.0))

    println("A Fatura é: R$ "+ "%.2f".format(fatura.getTotalFatura()))
}