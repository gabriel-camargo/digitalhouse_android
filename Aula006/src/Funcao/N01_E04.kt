package Funcao
import kotlin.random.Random

/**
 * 4. Jogo de Craps. Faça um programa de implemente um jogo de Craps. O jogador
 * lança um par de dados, obtendo um valor entre 2 e 12. Se, na primeira jogada, você
 * tirar 7 ou 11, você um "natural" e ganhou. Se você tirar 2, 3 ou 12 na primeira
 * jogada, isto é chamado de "craps" e você perdeu. Se, na primeira jogada, você fez
 * um 4, 5, 6, 8, 9 ou 10,este é seu "Ponto". Seu objetivo agora é continuar jogando os
 * dados até tirar este número novamente. Você perde, no entanto, se tirar um 7 antes
 * de tirar este Ponto novamente. Exemplo:
 *
 * a)
 * Rolar dados? (s ou n)
 * Você tirou 7! Parabéns você ganhou!
 *
 * b)
 * Rolar dados? (s ou n)
 * Você tirou 8! Aperte enter para tentar novamente
 *
 * Você tirou 7! Você perdeu =(
 *
 * Dica: Para obter valores aleatórios use
 * Random.nextInt(DE, ATE)
 */

fun rolarDados(): Int = Random.nextInt(2, 12)

fun segundaRodada(dado: Int) {
    do {
        print("Rolar dados?(s/n)")
        var resposta = readLine()!!.toUpperCase()
        if (resposta == "N") break

        var dadoSegundaRodada = rolarDados()

        when (dadoSegundaRodada) {
            dado -> {
                println("Voce tirou $dadoSegundaRodada . Voce Ganhou!!!")
                break
            }
            7 -> {
                println("Voce tirou $dadoSegundaRodada. Craps! Voce Perdeu :( ")
                break
            }
            else -> println("Voce tirou $dadoSegundaRodada. Jogue novamente ")
        }
    } while (true)
}

fun main() {

    do {
        print("Rolar dados?(s/n)")
        var resposta = readLine()!!.toUpperCase()
        if (resposta == "N") break

        var dados = rolarDados()

        when (dados) {
            7, 11 -> {
                println("Voce tirou $dados. Voce Ganhou !!!")
                break
            }
            2, 3, 12 -> {
                println("Voce tirou $dados. Craps! Voce Perdeu :( ")
                break
            }
            else -> {
                println("Voce tirou $dados. Jogue novamente ")
                segundaRodada(dados)
                break
            }
        }
    } while (true)

}