class Atleta(val nome: String) {
    var nivel: Int = 0
    var energia: Int = 0

    constructor(nome: String, nivel:Int, energia:Int)  :this(nome) {
        this.nivel = nivel
        this.energia = energia
    }

}