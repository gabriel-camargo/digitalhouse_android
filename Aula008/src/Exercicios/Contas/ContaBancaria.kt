package Exercicios.Contas

abstract class ContaBancaria(val numConta: Int): IImprimivel {
    protected var saldo: Double = 0.0

    abstract fun sacar(valor: Double): Boolean
    abstract fun depositar(valor: Double): Boolean

    fun transferir(valor: Double, conta: ContaBancaria) {
        if(this.sacar(valor)) {
            if(!conta.depositar(valor)) {
                // Se não conseguir depositar na conta, devolve o valor para
                // a conta original
                this.saldo+= valor
            }
        }
    }
}