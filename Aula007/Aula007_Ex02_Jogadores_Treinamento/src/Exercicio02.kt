fun main() {
    val jogador1 = JogadorDeFutebol("Allejo",100,0,0,0)
    val jogador2 = JogadorDeFutebol("Janco Tianno", 50, 0, 0, 0)

    val sessaoDeTreinamento = SessaoDeTreinamento(50)

    sessaoDeTreinamento.treinar(jogador1)
    sessaoDeTreinamento.treinar(jogador2)
    sessaoDeTreinamento.treinar(jogador1)
    sessaoDeTreinamento.treinar(jogador1)
}