package com.gabrielcamargo.todolist.main.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gabrielcamargo.todolist.R
import com.gabrielcamargo.todolist.main.model.ToDoModel
import com.gabrielcamargo.todolist.main.repository.ToDoListRepository
import com.gabrielcamargo.todolist.main.viewmodel.ToDoListViewModel

class ToDoListFragment : Fragment() {

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

    companion object {
        fun newInstance() = ToDoListFragment()
    }
}