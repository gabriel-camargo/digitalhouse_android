package exercicios.equals_hashcode_tostring.ex02

/**
 * 1. Criar a classe Coca que tenha como propriedades um tamanho (Integer) e preço (Double).
 * 2. Na classe Main, criar duas Cocas com o mesmo tamanho.
 *  3. Usando equals, comparar se a primeira Coca criada é igual à segunda.
 *  Qual é o resultado?
 *  R: false
 *
 *  4. Sobrescrever o equals da classe Coca para que compare apenas o tamanho.
 *   5. Refazer a comparação utilizando o equals.
 *   Qual é o resultado? O que mudou? Por quê?
 *   R: O resultado agora é true, pois antes estava sendo comparado o endereço na memória dos objetos,
 *   e agora está sendo comparado o atribudo tamanho.
 */

fun main() {
    val coca = Coca(2, 5.5)
    val coca2 = Coca(2, 3.0)

    println(coca == coca2)
}