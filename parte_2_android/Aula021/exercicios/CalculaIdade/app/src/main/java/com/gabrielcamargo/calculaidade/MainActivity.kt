package com.gabrielcamargo.calculaidade

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_resposta.*
import java.util.*
import kotlin.math.max

class MainActivity : AppCompatActivity(), ICalcular {
    val respostaFragment = RespostaFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = supportFragmentManager

        val formularioFragment = FormularioFragment()
        val transactionForm = manager.beginTransaction()
        transactionForm.replace(R.id.frameFormulario, formularioFragment)
        transactionForm.commit()

        val transactionResposta = manager.beginTransaction()
        transactionResposta.replace(R.id.frameResposta, respostaFragment)
        transactionResposta.commit()
    }

    override fun calcularIdade(nome: String, anoNasc: Int) {
        val anoAtual = Calendar.getInstance().get(Calendar.YEAR);
        val idade = max(anoAtual-anoNasc, 0)
        var resposta = "Olá $nome, você tem $idade"

        resposta += if(idade == 1) " ano." else " anos."

        respostaFragment.respostaForm(resposta)
    }
}