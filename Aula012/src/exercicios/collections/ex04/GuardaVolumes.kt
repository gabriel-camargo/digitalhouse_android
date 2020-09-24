package exercicios.collections.ex04

class GuardaVolumes(val dicionario: MutableMap<Int, List<Peca>>, var contador: Int) {
    fun guardarPeca(listaPecas: MutableList<Peca>): Int {
        contador++

        dicionario.put(contador, listaPecas)

        return contador
    }

    fun mostrarPecas() {
        dicionario.forEach {
            print("Número: ${it.key} ")
            println("Peças: ${it.value}")
        }
    }

    fun mostrarPecas(numero: Int) {
        dicionario.forEach{
            if(it.key == numero) {
                println("Peça: ${it.value}")
            }
        }
    }

    fun devolverPeca(numero: Int) {
        dicionario.remove(numero)
    }

}