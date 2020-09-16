fun main() {
    val carro = Veiculo("Chevrolet", "Onix", 2018, "Preto",10.0)
    val carro2 = Veiculo("Hyundai", "HB20", 2017, "Branco",50.0)

    val cliente = Cliente("Gabriel", "Camargo", "gabriel.rodrigocam@gmail.com")
    val concessionaria= Concessionaria()

    concessionaria.vender(carro, cliente, 35000.00)
    concessionaria.vender(carro2, cliente, 27000.00)

    concessionaria.vendasRealizadas.forEach{ venda ->

        println("Uma venda de um ${venda.veiculo.marca} ${venda.veiculo.modelo}" +
                " foi feita para o cliente ${venda.cliente.nome} ${venda.cliente.sobrenome}" +
                " no valor de R$ " + "%.2f".format(venda.valorVenda))
        print("\n")
    }

}