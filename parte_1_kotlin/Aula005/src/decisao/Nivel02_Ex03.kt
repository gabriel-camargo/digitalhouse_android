/*Faça um programa que faça 5 perguntas para uma pessoa sobre um crime. Asperguntas são:"Telefonou para a vítima?"
"Esteve no local do crime?""Mora perto da vítima?""Devia para a vítima?""Já trabalhou com a vítima?"
O programa deve no final emitir uma classificação sobre a participação da pessoano crime.
Se a pessoa responder positivamente a 2 questões ela deve serclassificada como "Suspeita", entre 3 e 4 como "Cúmplice" e
 5 como "Assassino".Caso contrário, ele será classificado como "Inocente".Use “S” para sim e “N” para não.*/

fun main(){
    var cont: Int = 0
    println(" Responda as perguntas sobre o crime: ")

    print("1) Telefonou para a vítima?(S/N)")
    val pergunta1: String= readLine()!!.toString().toUpperCase()

    print("2) Esteve no local do crime? (S/N)")
    val pergunta2: String= readLine()!!.toString().toUpperCase()

    print("3) Mora perto da vítima?(S/N)")
    val pergunta3: String= readLine()!!.toString().toUpperCase()

    print("4) Devia para a vítima? (S/N)")
    val pergunta4: String= readLine()!!.toString().toUpperCase()

    print("5) Já trabalhou com a vítima?(S/N)")
    val pergunta5: String= readLine()!!.toString().toUpperCase()

    if(pergunta1 == "S") cont++
    if(pergunta2 == "S") cont++
    if(pergunta3 == "S") cont++
    if(pergunta4 == "S") cont++
    if(pergunta5 == "S") cont++

    when(cont){
        1,2 -> println("Suspeita")
        3,4 -> println("Cúmplice")
        5 -> println("Assassino")
        else -> println("Inocente")
    }

}