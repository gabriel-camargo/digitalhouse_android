package Exercicios.Contas

class ContaCorrente(numConta: Int, val taxaOperacao: Double): ContaBancaria(numConta) {

    override fun sacar(valor: Double): Boolean {
        if(this.saldo < valor) {
            println("Saldo insuficiente!")
            return false

        } else if(this.saldo < (valor + this.taxaOperacao)) {
            println("Saldo insuficiente utilizando a taxa de operação!")
            return false

        }

        this.saldo -= (valor + this.taxaOperacao)
        return true
    }

    override fun depositar(valor: Double): Boolean {
        if((this.saldo + valor) < taxaOperacao){
            println("O valor de depósito deve ser maior que a taxa de operação!")
            return false
        }

        this.saldo += (valor - this.taxaOperacao)
        return true
    }

    override fun mostrarDados() {
        println("--- Dados da Conta Corrente ---")
        println("Número da conta: $numConta \n" +
                "Taxa de Operação: R$ "+ "%.2f".format(this.taxaOperacao) +"   \n" +
                "Saldo: R$ " + "%.2f".format(this.saldo)  + "\n"
        )
    }

}