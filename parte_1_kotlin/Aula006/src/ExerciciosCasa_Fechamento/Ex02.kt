package ExerciciosCasa_Fechamento

/**
 * 2) Escrever o código que deve analisar duas cadeias de texto e, caso sejam
 * diferentes, retornar true, ou, caso sejam iguais, retornar false.
 */

fun compararStrings(t1:String,t2:String) = (t1!=t2)

fun main(){
    print(compararStrings("Texto 1","Texto 1"))
}