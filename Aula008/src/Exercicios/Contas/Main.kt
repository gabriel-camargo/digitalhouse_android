package Exercicios.Contas

fun main() {
    val relatorio = Relatorio()

    val contaCorrente = ContaCorrente(123, 20.0)
    val contaPoupanca = ContaPoupanca(321, 200.0)
    val contaPoupanca2 = ContaPoupanca(321, 200.0)

    contaCorrente.depositar(1000.00)
    contaPoupanca.depositar(500.00)

    contaCorrente.sacar(950.0)
    contaPoupanca.sacar(600.0)

    contaPoupanca.transferir(30.0, contaCorrente)


    val santander = Banco()
    santander.inserir(contaCorrente)
    santander.inserir(contaPoupanca)
    santander.remover(contaPoupanca2)

    relatorio.gerarRelatorio(santander)

    val contaPesquisa: ContaBancaria? = santander.procurarConta(321)
    contaPesquisa?.let {
        relatorio.gerarRelatorio(it)
    }

}