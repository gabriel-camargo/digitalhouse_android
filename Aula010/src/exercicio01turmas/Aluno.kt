package exercicio01turmas

class Aluno(nome: String, registro: String): Pessoa(nome, registro) {
    override val podeAssistirAula: Boolean
        get() = true

    override val podeFazerLicoesDeCasa: Boolean
        get() = true
}