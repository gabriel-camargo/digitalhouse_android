package Lista

/**
 * 2. Faça um Programa para um caixa eletrônico. O programa deverá perguntar ao
 * usuário a valor do saque e depois informar quantas notas de cada valor serão
 * fornecidas. As notas disponíveis serão as de 1, 5, 10, 50 e 100 reais. O valor
 * mínimo é de 10 reais e o máximo de 600 reais. O programa não deve se preocupar
 * com a quantidade de notas existentes na máquina.
 */

fun main(){
    var cedulas = arrayOf<Int>(100,50,10,5,1)
    var saque: Int
    do{
        print("Digite o valor que será sacado : ")
        saque = readLine()!!.toInt()

        if(saque in 10..600) break

        println("Valor inválido! Saque é permitido a partir de R$10,00  ate o valor de R$600,00)")
    }while(true)

    for(cedula in cedulas){
        var nota=saque/cedula
        saque = saque%cedula

        if(nota>0)  println("$nota notas de R$ "+cedula)
    }
}