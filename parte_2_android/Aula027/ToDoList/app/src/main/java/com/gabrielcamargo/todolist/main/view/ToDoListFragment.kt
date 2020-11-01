package com.gabrielcamargo.todolist.main.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gabrielcamargo.todolist.R

class ToDoListFragment : Fragment() {

    lateinit var viewToDo: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewToDo = inflater.inflate(R.layout.fragment_to_do_list, container, false)

        val viewManager = LinearLayoutManager(viewToDo.context)
        val recyclerView = viewToDo.findViewById<RecyclerView>(R.id.recycler_fragmentToDo)

        return viewToDo
    }

    companion object {
        fun newInstance() = ToDoListFragment()
    }
}