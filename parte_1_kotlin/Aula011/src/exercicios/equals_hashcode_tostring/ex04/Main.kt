package exercicios.equals_hashcode_tostring.ex04

/**
 * 1. Criar uma classe Funcionário que tenha como propriedades um nome
 * (String) e numeroDeRegistro (Integer).
 * 2. Criar na classe Main uma lista de funcionários e adicionar quatro funcionários novos.
 * 3. Criar um funcionário novo com um número de registro contido na lista e
 * perguntar se ele está na lista (utilizar a função contains)
 * R: Retornou false
 *
 * 4. Sobrescrever o equals da classe Funcionário para que compare apenas o
 * número de registro.
 *  5. Perguntar novamente se o funcionário novo está na lista.
 *  Qual é o resultado? O que mudou? Por quê?
 *  R: O resultado agora é true. O resultado mudou porque antes estava sendo
 *  comparado o endereço da memória em que o  objeto foi armazenado, e agora está
 *  sendo comparado apenas o atribudo numeroDeRegistro.
 */

fun main() {
    val listaFuncionarios = ArrayList<Funcionario>()

    val funcionario1 = Funcionario("Fun 1", 1)
    val funcionario2 = Funcionario("Fun 2", 2)
    val funcionario3 = Funcionario("Fun 3", 3)
    val funcionario4 = Funcionario("Fun 4", 4)

    listaFuncionarios.add(funcionario1)
    listaFuncionarios.add(funcionario2)
    listaFuncionarios.add(funcionario3)
    listaFuncionarios.add(funcionario4)

    val novoFuncionario = Funcionario("Fun 1", 1)
    println(listaFuncionarios.contains(novoFuncionario))
}
