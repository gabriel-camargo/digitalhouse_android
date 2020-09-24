package exercicios.collections.ex01

fun main() {
    val loteriaSonhos =
        mapOf<Int, String>(0 to "Ovos", 1 to "Água", 2 to "Escopeta", 3 to "Cavalo", 4 to "Dentista", 5 to "Fogo")

    val nomesApelidos =
        mapOf<String, List<String>>(
            "João" to listOf<String>("Juan", "Fissura", "Maromba"),
            "Miguel" to listOf("Night Watch", "Bruce Wayne", "Tampinha"),
            "Maria" to listOf("Wonder Woman", "Mary", "Marilene"),
            "Lucas" to listOf("Lukinha", "Jorge", "George")
        )

    loteriaSonhos.forEach{
        println(it.key)
        println(it.value)
    }

    println("-----")

    nomesApelidos.forEach{
        println(it.key)
        println(it.value)
    }
}