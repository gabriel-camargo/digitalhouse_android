package com.turma05.kotlinrickapp.listagem.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.turma05.kotlinrickapp.listagem.model.PersonagemModel
import com.turma05.kotlinrickapp.listagem.repository.PersonagemRepository
import kotlinx.coroutines.Dispatchers

class PersonagemViewModel(
    private val repository: PersonagemRepository
): ViewModel() {

    var personagens: List<PersonagemModel> = listOf()
    var personagensAntesDaBusca = listOf<PersonagemModel>()

    private var _page: Int = 1
    private var _total: Int = 0

    fun obterLista(name: String? = null, page: Int = 1) = liveData(Dispatchers.IO) {
        val response = repository.obterLista(name,page)

        personagens = response.results
        _total = response.info.paginas

        emit(response.results)
    }

    fun proximaPagina(name: String? = null) = liveData(Dispatchers.IO) {
        personagensAntesDaBusca = personagens

        if(_page + 1 <= _total) {
            _page++

            val response = repository.obterLista(name, _page)
            emit(response.results)
        }
    }

    fun buscar(name: String? = null, page: Int = 1) = liveData(Dispatchers.IO) {
        personagensAntesDaBusca = personagens

        val response = repository.obterLista(name, page)
        emit(response.results)
    }

    fun listaAntiga() = personagensAntesDaBusca

    class PersonagemViewModelFactory(
        private val repository: PersonagemRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return PersonagemViewModel(repository) as T
        }
    }
}