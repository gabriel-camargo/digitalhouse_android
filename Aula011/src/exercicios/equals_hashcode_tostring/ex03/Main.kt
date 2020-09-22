package exercicios.equals_hashcode_tostring.ex03

/**
 * 1. Criar uma classe Aluno que tenha como propriedades um nome (String) e
 * numeroDeAluno (Integer).
 * 2. Na classe Main, criar uma lista de alunos e adicionar quatro alunos novos.
 * 3. Criar um aluno novo com um número de aluno contido na lista e perguntar
 * se ele está na lista (utilizar a função contains).
 * R: Retornou false
 *
 * 4. Sobrescrever o equals da classe Aluno para que compare apenas o número de aluno.
 * 5. Perguntar novamente se o aluno novo está na lista.
 * Qual é o resultado? O que mudou? Por quê?
 * R: O resultado agora é true. O resultado mudou porque antes estava sendo
 *  comparado o endereço da memória em que o  objeto foi armazenado, e agora está
 *  sendo comparado apenas o atribudo numeroDeAluno.
 */
fun main() {
    val listaAlunos = ArrayList<Aluno>()

    val aluno1 = Aluno("Aluno 1", 1)
    val aluno2 = Aluno("Aluno 2", 2)
    val aluno3 = Aluno("Aluno 3", 3)
    val aluno4 = Aluno("Aluno 4", 4)

    listaAlunos.add(aluno1)
    listaAlunos.add(aluno2)
    listaAlunos.add(aluno3)
    listaAlunos.add(aluno4)

    val novoAluno = Aluno("Novo Aluno", 3)

    println(listaAlunos.contains(novoAluno))
}