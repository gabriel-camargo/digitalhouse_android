package exercicios.collections.ex04

fun main() {

    val guardaVolumes = GuardaVolumes(mutableMapOf<Int, List<Peca>>(), 0)

    val peca1 = Pertence("Marca 1", "Modelo 1")
    val peca2 = Pertence("Marca 2", "Modelo 2")

    val listaPecas = mutableListOf<Peca>(peca1, peca2)

    println(guardaVolumes.guardarPeca(listaPecas))

    guardaVolumes.mostrarPecas()

    guardaVolumes.devolverPeca(1)
    guardaVolumes.mostrarPecas()

}