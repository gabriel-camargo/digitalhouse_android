class Conta(val numConta: Int, val titular: Cliente) {
    var saldo: Double = 0.0

    constructor(
        numConta: Int,
        titular: Cliente,
        saldo: Double
    ) :this(numConta, titular) {
        this.saldo = saldo
    }

    fun depositar(valorDeposito: Double) {
        this.saldo += valorDeposito
        println(
            "\nDepósito de R$ " + "%.2f".format(valorDeposito) +
                    " foi realizado na sua conta, ${this.titular.nomeCompleto}. \n" +
                    "Seu saldo agora é de: R$ " + "%.2f".format(this.saldo)
        )
    }

    fun sacar(valorSaque: Double) {
        if(this.saldo < valorSaque) {
            println("Saldo insuficiente!")
            return
        }

        this.saldo -= valorSaque

        println(
            "\nUm saque no valor de R$ " + "%.2f".format(valorSaque) +
                    " foi realizado na sua conta, ${this.titular.nomeCompleto}. \n" +
                    "Seu saldo agora é de: R$ " + "%.2f".format(this.saldo)
        )
    }
}