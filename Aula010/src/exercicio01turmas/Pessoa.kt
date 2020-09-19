package exercicio01turmas

abstract class Pessoa(val nome: String, val registro: String) {
    open val podeAssistirAula: Boolean
        get() = false

    open val podeFazerLicoesDeCasa: Boolean
        get() = false

    open val podeDarAula: Boolean
        get() = false

    open val podeFazerChamada: Boolean
        get()= false
}