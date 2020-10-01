package exercicio03estoque

import kotlin.math.max

class Estoque(private var nome: String, private var qtdMin: Int, private var qtdAtual: Int) {

    fun mudarNome(novoNome: String) {
        this.nome = novoNome
    }

    fun mudarQtdMinima(novaQtdMin: Int) {
        this.qtdMin = novaQtdMin
        this.qtdMin = max(0, this.qtdMin)
    }

    fun repor(qtd: Int) {
        this.qtdAtual+=qtd
        this.qtdAtual = max(this.qtdAtual, 0)
    }

    fun darBaixa(qtd: Int) {
        this.qtdAtual-=qtd
        this.qtdAtual = max(this.qtdAtual, 0)
    }

    fun mostra(): String {
        var relatorio: String = ""

        relatorio+= "Nome: ${this.nome}, "
        relatorio+= "Qtd mínima: ${this.qtdMin}, "
        relatorio+= "Qtd atual: ${this.qtdAtual}."

        return relatorio
    }

    fun precisaRepor() = (this.qtdAtual <= this.qtdMin)
}