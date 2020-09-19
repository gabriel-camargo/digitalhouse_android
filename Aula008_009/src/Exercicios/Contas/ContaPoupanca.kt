package Exercicios.Contas

class ContaPoupanca(numConta: Int, var limite: Double): ContaBancaria(numConta) {

    override fun sacar(valor: Double): Boolean {
        if(this.saldo < (valor - limite)) {
            println("Saldo e limite insuficiente!")
            return false
        }

        this.saldo -= valor

        if(this.saldo < 0) {
            println("Seu saldo esta negativo! Você esta utilizando o limite de sua Conta Poupança.")
        }

        return true
    }

    override fun depositar(valor: Double): Boolean {
        this.saldo += valor

        return true
    }

    override fun mostrarDados() {
        println("--- Dados da Conta Poupança ---")
        println("Número da conta: $numConta \n" +
                "Limite: R$ "+ "%.2f".format(this.limite) +" \n" +
                "Saldo: R$ " + "%.2f".format(this.saldo) + "\n"
        )
    }
}