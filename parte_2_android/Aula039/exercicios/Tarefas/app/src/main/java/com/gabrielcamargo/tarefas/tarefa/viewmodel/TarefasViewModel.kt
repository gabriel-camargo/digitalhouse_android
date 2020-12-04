package com.gabrielcamargo.tarefas.tarefa.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.gabrielcamargo.tarefas.tarefa.entity.TarefaEntity
import com.gabrielcamargo.tarefas.tarefa.repository.TarefaRepository
import kotlinx.coroutines.Dispatchers

class TarefasViewModel(
    private val repository: TarefaRepository
) : ViewModel() {

    private val _tarefas = ArrayList<TarefaEntity>()
    val _tarefasMutable = MutableLiveData<List<TarefaEntity>>()

    fun addTarefa(tarefa: TarefaEntity) = liveData(Dispatchers.IO) {
        repository.addTarefa(tarefa)
        _tarefas.add(tarefa)
        _tarefasMutable.value = _tarefas
        emit(_tarefasMutable)
    }

    fun count() = liveData(Dispatchers.IO) {
        val count = repository.count()
        emit(count)
    }

    class TarefasViewModelFactory(
        private val repository: TarefaRepository
    ): ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return TarefasViewModel(repository) as T
        }
    }
}