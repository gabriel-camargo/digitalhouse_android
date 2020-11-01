package com.gabrielcamargo.todolist.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gabrielcamargo.todolist.main.model.ToDoModel
import com.gabrielcamargo.todolist.main.repository.ToDoListRepository

class ToDoListViewModel(
    private val repository: ToDoListRepository
): ViewModel() {
    val toDos = MutableLiveData<List<ToDoModel>>()

    fun getToDos() {
        repository.getToDos {
            toDos.value = it
        }
    }

    @Suppress("UNCHECKED_CAST")
    class ToDoListViewModelFactory(
        private val repository: ToDoListRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ToDoListViewModel(repository) as T
        }

    }
}