class Carro(val consumoPorKm:Double) {
    var combustivelQtd: Double = 0.0

    fun adicionarCombustivel(qtd:Double) {
        this.combustivelQtd+=qtd
    }

    fun andar(km: Int) {
        this.combustivelQtd-= (this.consumoPorKm*km)
        if(this.combustivelQtd < 0) {
            println("Sua gasolina acabou... 😓")
            this.combustivelQtd=0.0
        }
    }

    fun obterGasolina() {
        println("Você tem $combustivelQtd litros no tanque")
    }
}