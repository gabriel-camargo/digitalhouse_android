fun main() {
    print("Digite a temperatura em: ")
    var fahrenheit: Double = readLine()!!.toDouble()

    println("Temperatura em Celsius: " + "%.2f".format(fahrenheitToCelsius(fahrenheit)))
}

fun fahrenheitToCelsius(fahrenheit: Double): Double {
    val celsius: Double = 5 * ((fahrenheit-32) / 9);
    return celsius
}