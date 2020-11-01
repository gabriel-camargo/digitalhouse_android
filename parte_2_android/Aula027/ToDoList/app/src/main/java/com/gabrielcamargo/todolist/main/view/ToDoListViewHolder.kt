package com.gabrielcamargo.todolist.main.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gabrielcamargo.todolist.R
import com.gabrielcamargo.todolist.main.model.ToDoModel
import com.google.android.material.checkbox.MaterialCheckBox

class ToDoListViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
    private val txtName = view.findViewById<TextView>(R.id.txtToDo_itemToDo)
    private val checkBox = view.findViewById<MaterialCheckBox>(R.id.cbToDo_itemToDo)

    fun bind(toDo: ToDoModel) {
        txtName.text = toDo.name
        checkBox.isChecked = toDo.isFinished
    }
}