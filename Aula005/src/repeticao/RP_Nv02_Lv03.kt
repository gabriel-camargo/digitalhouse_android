//Desenvolva um gerador de tabuada, capaz de gerar a tabuada de qualquer
//número inteiro entre 1 a 10. O usuário deve informar de qual número ele deseja ver
//a tabuada. A saída deve ser conforme o exemplo abaixo:

fun main() {
    var num = 0
    do {
        print("Digite um número de 1 a 10 para ver sua tabuada: ")
        num = readLine()!!.toInt()

        if(num in 1..10) break

        println("Número inválido!")
    } while(true)

    for(i in 1..10) {
        println("$num X $i = " + (num*i))
    }


}