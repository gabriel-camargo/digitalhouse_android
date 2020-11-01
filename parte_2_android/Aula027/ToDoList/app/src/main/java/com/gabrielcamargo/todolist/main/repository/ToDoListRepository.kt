package com.gabrielcamargo.todolist.main.repository

import android.content.Context
import com.gabrielcamargo.todolist.main.model.ToDoModel

class ToDoListRepository(private val context: Context) {

    fun getToDos(callback: (toDos: List<ToDoModel>) -> Unit) {
        callback.invoke(listOf<ToDoModel>(
            ToDoModel("Tarefa 1", true),
            ToDoModel("Tarefa 2", false),
            ToDoModel("Tarefa 3", false)

        ))
    }
}