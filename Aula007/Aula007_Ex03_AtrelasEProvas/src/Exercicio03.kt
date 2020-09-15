fun main() {
    val atleta1 = Atleta("Nome 1",50,500)
    val atleta2 = Atleta("Nome 2", 30, 700)

    val prova1 = Prova(25, 100)
    val prova2 = Prova(49, 350)
    val prova3 = Prova(30, 100)

    val prova4 = Prova(29, 100)
    val prova5 = Prova(10, 300)
    val prova6 = Prova(35, 300)

    mostrarResultadoProva(prova1.realizarProva(atleta1))
    mostrarResultadoProva(prova2.realizarProva(atleta1))
    mostrarResultadoProva(prova3.realizarProva(atleta1)) // não realizou por causa da energia

    mostrarResultadoProva(prova4.realizarProva(atleta2))
    mostrarResultadoProva(prova5.realizarProva(atleta2))
    mostrarResultadoProva(prova6.realizarProva(atleta2)) // não realizou por causa do nível

}

fun mostrarResultadoProva(podeRealizar:Boolean) {
    if(podeRealizar) {
        println("Prova realizada!")
    } else {
        println("O atleta não pode realizar a prova.")
    }
}