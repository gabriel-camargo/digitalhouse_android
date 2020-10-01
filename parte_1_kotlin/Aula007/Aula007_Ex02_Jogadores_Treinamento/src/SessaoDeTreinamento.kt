class SessaoDeTreinamento(val experiencia: Int) {

    fun treinar(jogador: JogadorDeFutebol) {
        jogador.correr()
        jogador.fazerGol()
        jogador.correr()

        println("O jogador ${jogador.nome} ganhou $experiencia de XP!")
        println("Sua experiência foi de ${jogador.experiencia} para... " +
                "${(jogador.experiencia + experiencia)}\n")

        jogador.experiencia+= experiencia
    }
}