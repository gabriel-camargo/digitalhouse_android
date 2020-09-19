package exercicio02fatura

import kotlin.math.max

class Item(
    val num: Int,
    val descricao: String,
    private var _qtdComprada: Int,
    private var _preco: Double
) {

    val getQtdComprada: Int get() = this._qtdComprada
    val getPreco: Double get() = this._preco

    init {
        this._qtdComprada = max(0, this._qtdComprada)
        this._preco = max(0.0, this._preco)
    }

    fun printarItem() {
        println()
        println("Número: ${this.num}")
        println("Descrição: ${this.descricao}")
        println("Qtd. comprada: ${this._qtdComprada}")
        println("Preço: R$ " + "%.2f".format(this._preco))
    }
}