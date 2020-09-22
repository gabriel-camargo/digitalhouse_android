package exercicios.exceptions.ex03

class CalculaMatematico {

    fun divisao(dividendo: Int, divisor: Int): Int {
        if(divisor == 0) {
            throw ArithmeticException("Não é possível dividir por zero!")
        }

        return dividendo / divisor
    }

}