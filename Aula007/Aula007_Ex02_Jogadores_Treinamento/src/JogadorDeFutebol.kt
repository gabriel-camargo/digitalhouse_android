class JogadorDeFutebol(val nome: String) {
    var energia:Int = 0
    var alegria:Int = 0
    var gols:Int = 0
    var experiencia:Int = 0

    constructor(
        nome: String,
        energia: Int,
        alegria: Int,
        gols: Int,
        experiencia: Int
    ): this(nome) {
        this.alegria=alegria
        this.energia=energia
        this.gols=gols
        this.experiencia=experiencia
    }

    fun fazerGol() {
        this.energia-=5
        this.alegria+=10
        this.gols+=1

        println("GOOOOOOOOOOL! De ${this.nome}!")
    }

    fun correr() {
        this.energia-=10
        println("${this.nome} cansou...")
    }

}