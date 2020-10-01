class Prova(val dificuldade:Int, val energiaNecessaria: Int) {

    fun realizarProva(atleta: Atleta):Boolean {
        if(
            (atleta.nivel >= this.dificuldade)
            &&
            (atleta.energia >= this.energiaNecessaria)
        ) {
            atleta.energia-=energiaNecessaria
            return true
        }
        return false
    }
}