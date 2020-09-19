package exercicio03estoque

fun main() {
    val estoque = Estoque("estoque", 5, 10)

    println(estoque.mostra())
    println(estoque.precisaRepor())

    estoque.darBaixa(5)
    println(estoque.mostra())
    println(estoque.precisaRepor())

    estoque.repor(20)
    println(estoque.mostra())
    println(estoque.precisaRepor())

    estoque.mudarNome("Teste mudar nome")

    println(estoque.mostra())
    println(estoque.precisaRepor())
}
