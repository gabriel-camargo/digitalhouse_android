class Concessionaria {
    val vendasRealizadas: MutableList<Venda> = mutableListOf<Venda>()

    fun vender(veiculo: Veiculo, cliente: Cliente, valor: Double) {
        var venda = Venda(cliente, veiculo, valor)
        this.vendasRealizadas.add(venda)
    }
}