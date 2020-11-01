package com.gabrielcamargo.todolist.main.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gabrielcamargo.todolist.R
import com.gabrielcamargo.todolist.main.model.ToDoModel

class ToDoListAdapter(private val dataSet: List<ToDoModel>):
    RecyclerView.Adapter<ToDoListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoListViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_to_do, parent, false)

        return ToDoListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ToDoListViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

}