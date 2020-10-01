package ExerciciosCasa_Fechamento

/**
 * 5) Escrever um código que deve analisar quatro números inteiros e, caso numA
 * seja maior que numC e numD ou caso numB seja maior que numC e numD,
 * retornar true, caso contrário, retornar false.
 */

fun compararNumeros(na: Int, nb: Int, nc: Int, nd: Int) =
    (na>nc && na>nd) || (nb>nc && nb>nd)
fun main(){
    print("Informe o numero(A): ")
    val numA = readLine()!!.toInt()

    print("Informe o numero(B): ")
    val numB = readLine()!!.toInt()

    print("Informe o numero(C): ")
    val numC = readLine()!!.toInt()

    print("Informe o numero(D): ")
    val numD = readLine()!!.toInt()

    print(compararNumeros(numA, numB, numC, numD))
}