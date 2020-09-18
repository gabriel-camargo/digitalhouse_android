package Exercicios.Contas

class Banco: IImprimivel {
    private val contasBancarias = ArrayList<ContaBancaria>()

    fun inserir(conta: ContaBancaria) {
        contasBancarias.add(conta)
    }

    fun remover(conta: ContaBancaria) {
        contasBancarias.remove(conta)
    }

    fun procurarConta(numContaPesquisa: Int) = contasBancarias.find { it.numConta == numContaPesquisa }

    override fun mostrarDados() {
        contasBancarias.forEach {
            it.mostrarDados()
        }
    }
}