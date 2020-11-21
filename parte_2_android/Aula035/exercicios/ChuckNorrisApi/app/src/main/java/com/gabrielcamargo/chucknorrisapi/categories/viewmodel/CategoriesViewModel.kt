package com.gabrielcamargo.chucknorrisapi.categories.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.gabrielcamargo.chucknorrisapi.categories.repository.CategoriesRepository
import kotlinx.coroutines.Dispatchers

class CategoriesViewModel(
    private val repository: CategoriesRepository
) : ViewModel() {
    var categories: List<String> = listOf()

    fun getCategories() = liveData(Dispatchers.IO){
        val response = repository.getCategories()
        categories = response
        emit(response)
    }

    @Suppress("UNCHECKED_CAST")
    class CategoriesViewModelFactory(
        private val repository: CategoriesRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CategoriesViewModel(repository) as T
        }

    }
}