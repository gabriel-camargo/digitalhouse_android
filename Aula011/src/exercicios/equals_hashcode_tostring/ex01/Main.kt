package exercicios.equals_hashcode_tostring.ex01

/**
 *  1. Criar a classe Pessoa que tenha como propriedades nome (String) e RG (Integer).
 *  2. Na classe Main, criar duas pessoas com o mesmo número de RG.
 *  3. Usando equals, comparar se a primeira pessoa criada é igual à segunda.
 *  Qual é o resultado?
 *  R: false
 *
 *  4. Sobrescrever o equals da classe Pessoa para que compare apenas o número de RG.
 *  5. Refazer a comparação utilizando o equals.
 *  Qual é o resultado? O que mudou? Por quê?
 *  R: true, pois o método equals e hashCode só levam em conta o atributo RG da classe pessoa
 *  para comparação.
 */

fun main() {
    val pessoa1 = Pessoa("Pessoa 1", 123)
    val pessoa2 = Pessoa("Pessoa 2", 123)

    println(pessoa1 == pessoa2)
}
