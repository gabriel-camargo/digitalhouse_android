fun main() {
    print("Digite seu salário (por hora): ")
    var salarioHora: Double = readLine()!!.toDouble()

    print("Digite a quantidade de horas trabalhadas no mês: ")
    var horasTrabalhadas: Int = readLine()!!.toInt()

    var salarioBruto: Double = salarioHora * horasTrabalhadas

    var descImpostoRenda: Double = salarioBruto * 11/100
    var descINSS: Double = salarioBruto * 8/100
    var descSindicato: Double = salarioBruto * 5/100

    var salarioLiquido: Double = salarioBruto - descINSS - descImpostoRenda - descSindicato

    println("+ Salário Bruto: R$ $salarioBruto")
    println("- IR (11%): R$ $descImpostoRenda")
    println("- INSS (8%): R$ $descINSS")
    println("- Sindicato (5%) : R$ $descSindicato")
    println("= Salário Líquido: R$ $salarioLiquido")
}