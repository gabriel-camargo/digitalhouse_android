package com.gabrielcamargo.todolist.main.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gabrielcamargo.todolist.R
import com.gabrielcamargo.todolist.main.model.ToDoModel
import com.gabrielcamargo.todolist.main.repository.ToDoListRepository
import com.gabrielcamargo.todolist.main.viewmodel.ToDoListViewModel
import com.google.android.material.button.MaterialButton

class ToDoListFragment : Fragment(), View.OnClickListener {

    lateinit var viewToDo: View
    lateinit var viewModel: ToDoListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewToDo = inflater.inflate(R.layout.fragment_to_do_list, container, false)


        viewModel = ViewModelProvider(
            this,
            ToDoListViewModel.ToDoListViewModelFactory(ToDoListRepository(viewToDo.context))
        ).get(ToDoListViewModel::class.java)

        viewModel.toDos.observe(this, Observer {
            createList(it)
        })

        viewModel.getToDos()

        val btnAddToDo = viewToDo.findViewById<MaterialButton>(R.id.btnAddTodo_fragmentToDo)
        btnAddToDo.setOnClickListener(this)

        return viewToDo
    }

    fun createList(toDos: List<ToDoModel>) {
        val viewManager = LinearLayoutManager(viewToDo.context)
        val recyclerView = viewToDo.findViewById<RecyclerView>(R.id.recycler_fragmentToDo)

        val toDoListAdapter = ToDoListAdapter(toDos)

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = toDoListAdapter
        }
    }


    fun addNewTodo() {
        viewModel.setToDo(ToDoModel("Nova tarefa"))
    }

    companion object {
        fun newInstance() = ToDoListFragment()
    }

    override fun onClick(v: View?) {
        when(v?.getId()){
            R.id.btnAddTodo_fragmentToDo -> addNewTodo()
        }
    }
}