package Exercicios.Contas

fun main() {
    val banco = Banco()

    println("Bem vindo!")
    menuInicial(banco)
}

fun menuInicial(banco: Banco) {
    println("--- Menu Inicial ---")
    do {
        println(
            "1- Criar conta \n" +
                    "2- Selecionar uma conta \n" +
                    "3- Remover uma conta \n" +
                    "4- Gerar relatório das suas contas \n" +
                    "5- Finalizar aplicação \n"
        )

        msgReadLine()
        var op: Int = readLine()!!.toInt()

        when (op) {
            1 -> criarConta(banco)
            2 -> selecionarConta(banco)
            3 -> removerConta(banco)
            4 -> {
                val relatorio = Relatorio()
                relatorio.gerarRelatorio(banco)
            }
            5 -> {
                println("Saindo da aplicação, até mais!")
                break
            }
            else -> {
                println("Opção inválida!")
            }
        }

    } while (true)
}

fun menuConta(banco: Banco, conta: ContaBancaria) {
    do {
        println("--- Menu da Conta ---")

        println(
            "1- Depositar \n" +
                    "2- Sacar \n" +
                    "3- Transferir \n" +
                    "4- Mostrar dados da conta \n " +
                    "5- Voltar ao menu inicial "
        )

        msgReadLine()
        var op = readLine()!!.toInt()
        when(op) {
            1 -> {
                print("Digite o valor a ser depositado: ")
                var valDeposito = readLine()!!.toDouble()
                conta.depositar(valDeposito)
            }
            2 -> {
                print("Digite o valor a ser sacado: ")
                var valSaque = readLine()!!.toDouble()
                conta.sacar(valSaque)
            }
            3 -> {
                do {
                    print("Digite o número da conta para qual deseja realizar a transferência" +
                            "(ou digite zero para voltar ao menu ) : ")
                    val numContaTransf = readLine()!!.toInt()

                    if(numContaTransf == 0) break

                    val contaTransf = banco.procurarConta(numContaTransf)
                    if(contaTransf == null) {
                        println("Conta não encontrada :/")
                    } else {
                        print("Digite o valor da transferência: ")
                        val valorTransf = readLine()!!.toDouble()

                        conta.transferir(valorTransf, contaTransf)
                        println("Valor transferido!")
                    }
                } while (true)

            }
            4 -> {
                val relatorio = Relatorio()
                relatorio.gerarRelatorio(conta)
            }
            5 -> {
                break
            }
            else -> {
                println("Opção inválida!")
            }
        }

    } while (true)
}

fun criarConta(banco: Banco) {
    do {
        println("Que tipo de conta você deseja criar? \n" +
                "1- Conta corrente \n" +
                "2- Conta poupança \n" +
                "3- Voltar ao menu anterior")

        msgReadLine()
        var opConta = readLine()!!.toInt()

        when(opConta) {
            1, 2 -> {
                print("Digite o número da sua nova conta: ")
                var numConta = readLine()!!.toInt()

                if(numConta <= 0) {
                    println("O número da conta deve ser maior que zero!")
                    continue
                }

                var contaPesquisa = banco.procurarConta(numConta)
                if( contaPesquisa != null) {
                    println("Atenção! Ja existe uma conta bancária com este número!")
                    continue
                }

                if(opConta == 1) {
                    print("Digite a taxa de operação da conta: ")
                    var taxaOperacao = readLine()!!.toDouble()

                    var conta = ContaCorrente(numConta, taxaOperacao)
                    banco.inserir(conta)

                    println("Conta corrente criada com sucesso!")
                } else {
                    print("Digite o limite da conta: ")
                    var limite = readLine()!!.toDouble()

                    var conta = ContaPoupanca(numConta, limite)
                    banco.inserir(conta)

                    println("Conta poupança criada com sucesso!")
                }
                break
            }
            3 -> {
                break
            }
            else -> {
                println("Digite um valor válido!")
            }
        }
    } while (true)
}

fun selecionarConta(banco: Banco) {
    do {
        print("Digite o número da sua conta, ou digite 0(zero) para voltar ao menu anterior: ")
        var numConta = readLine()!!.toInt()

        if(numConta == 0) {
            break
        } else {
            var conta = banco.procurarConta(numConta)

            if (conta == null) {
                println("Nenhuma conta encontrada :(")
            } else {
                menuConta(banco, conta)
                break
            }
        }
    } while(true)
}

fun removerConta(banco: Banco) {
    do {
        print("Digite o número da conta a ser removida " +
                "(ou digite 0 (ZERO) para voltar ao menu inicial) : ")
        val numConta = readLine()!!.toInt()

        if(numConta == 0) {
            break
        }

        val contaPesquiusa = banco.procurarConta(numConta)
        if(contaPesquiusa == null) {
            println("Conta não encontrada ;/")
        } else {
            banco.remover(contaPesquiusa)
            println("Conta removida com sucesso!")

            break
        }
    } while(true)
}

fun msgReadLine() {
    print("Digite o número da ação que deseja realizar: ")
}