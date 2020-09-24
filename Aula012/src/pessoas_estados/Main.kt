package pessoas_estados

fun main() {
    val estado1 = Estado("AC", "Acre")
    val estado2 = Estado("RN", "Rio Grande do Norte")
    val estado3 = Estado("GO", "Goiás")
    val estado4 = Estado("SP", "São Paulo")
    val estado5 = Estado("PR", "Paraná")

    val pessoas = listOf(
        Pessoa("Pessoa 1", estado1),
        Pessoa("Pessoa 2", estado2),
        Pessoa("Pessoa 3", estado5),
        Pessoa("Pessoa 4", estado4),
        Pessoa("Pessoa 5", estado3),
        Pessoa("Pessoa 6", estado5),
        Pessoa("Pessoa 7", estado1),
        Pessoa("Pessoa 8", estado2),
        Pessoa("Pessoa 9", estado2),
        Pessoa("Pessoa 10", estado4),
        Pessoa("Pessoa 11", estado4),
    )

//    val pessoasPorEstado = mutableMapOf<String, MutableList<Pessoa>>()
//
//    pessoas.forEach{
//        if(!pessoasPorEstado.containsKey(it.estado.sigla)) {
//            pessoasPorEstado[it.estado.sigla] = mutableListOf<Pessoa>()
//        }
//
//        pessoasPorEstado[it.estado.sigla]?.add(it)
//    }
//
//    println(pessoasPorEstado)
    println(pessoas.groupBy { it.estado.sigla })
}