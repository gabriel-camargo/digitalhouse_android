package com.gabrielcamargo.tarefas.tarefa.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.gabrielcamargo.tarefas.R
import com.gabrielcamargo.tarefas.db.AppDatabase
import com.gabrielcamargo.tarefas.tarefa.entity.TarefaEntity
import com.gabrielcamargo.tarefas.tarefa.repository.TarefaRepository
import com.gabrielcamargo.tarefas.tarefa.viewmodel.TarefasViewModel

class TarefasFragment : Fragment() {

    companion object {
        fun newInstance() = TarefasFragment()
    }

    private lateinit var _viewModel: TarefasViewModel
    private lateinit var _myView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _myView =  inflater.inflate(R.layout.tarefas_fragment, container, false)
        return _myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _viewModel = ViewModelProvider(
            this,
            TarefasViewModel.TarefasViewModelFactory(TarefaRepository(
                AppDatabase.getDatabase(_myView.context).tarefaDao()
            ))
        ).get(TarefasViewModel::class.java)

        _viewModel._tarefasMutable.observe(viewLifecycleOwner, Observer {
            createList(it)
        })

        criarTarefa(TarefaEntity(1, "Teste 1"))
        criarTarefa(TarefaEntity(2, "Teste 2"))
        criarTarefa(TarefaEntity(3, "Teste 3"))
    }

    fun criarTarefa(tarefaEntity: TarefaEntity) {
        _viewModel.addTarefa(tarefaEntity)
    }

    fun createList(lista: List<TarefaEntity>) {
        Toast.makeText(_myView.context, "opa", Toast.LENGTH_SHORT).show()
    }
}